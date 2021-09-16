package com.inception.paycrypt.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static com.inception.paycrypt.utils.constants.JwtConstants.*;

/**
 * Class for filtering incoming requests with JWT
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    /**
     * JwtSecret
     */
    @Value("${app.secret}")
    private String jwtSecret;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else {
            try {
                setAttributesToRequest(request, response);
                filterChain.doFilter(request, response);
            } catch (MalformedJwtException e) {
                response.sendError(HttpStatus.BAD_REQUEST.value(), "Missing or wrong token");
            } catch (ExpiredJwtException e) {
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token expired or malformed");
            }
        }
    }

    /**
     * Checks if a cookie is present on the request and if so, uses it
     *
     * @param request The incoming {@link HttpServletRequest}
     * @return optional of the cookie
     */
    private Optional<Cookie> getOptionalCookie(final HttpServletRequest request) {

        return request.getCookies() != null ? Arrays.stream(request.getCookies()).filter(
                cookie -> Objects.equals(cookie.getName(), COOKIE_NAME)).findFirst() : Optional.empty();
    }

    /**
     * If the user authenticated successfully sets the attributes on the request
     *
     * @param request The incoming {@link HttpServletRequest}
     * @param response The outgoing {@link HttpServletResponse}
     * @throws IOException when there is a IO error
     */
    private void setAttributesToRequest(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        Optional<Cookie> optionalCookie = getOptionalCookie(request);
        String headerJwt = null;

        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            headerJwt = authHeader.substring(7);
        }

        String token = optionalCookie.isPresent() ? optionalCookie.get().getValue() : headerJwt;

        if (token != null) {
            Jws<Claims> claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            Claims claimsBody = claims.getBody();
            String subject = claimsBody.getSubject();
            List<String> roles = Collections.singletonList(claims.getBody().get(CLAIMS_ROLES_KEY, String.class));

            if (roles.get(0) == null) {
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid token roles");
            } else {
                SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(token, subject, roles));
            }

            request.setAttribute("claims", claimsBody);
            request.setAttribute("jwtUserId", subject);
            request.setAttribute("jwtUserRoles", roles);

        }
    }
}

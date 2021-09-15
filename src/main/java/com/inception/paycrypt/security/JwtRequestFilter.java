package com.inception.paycrypt.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.inception.paycrypt.utils.constants.JwtConstants.CLAIMS_ROLES_KEY;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Value("${app.secret}")
    private String JwtSecret;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = getToken(request);
            Jws<Claims> claims = Jwts.parser().setSigningKey(JwtSecret).parseClaimsJws(token);
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
            filterChain.doFilter(request, response);
        } catch (MalformedJwtException e) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), "Missing or wrong token");
        } catch (ExpiredJwtException e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token expired or malformed");
        }
    }

    private String getToken(HttpServletRequest request) {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        throw new MalformedJwtException("Missing or wrong token");
    }
}

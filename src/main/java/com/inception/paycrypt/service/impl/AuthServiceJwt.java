package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.TokenDto;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.service.AuthService;
import com.inception.paycrypt.utils.constants.JwtConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * Authentication service
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Setter
@Component("authServiceJwt")
public class AuthServiceJwt implements AuthService {

    /**
     * The secret for the JWT authentication
     */
    @Value("${app.secret}")
    private String jwtSecret;

    /**
     * {@inheritDoc}
     */
    @Override
    public TokenDto generateToken(User user) {

        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, JwtConstants.TOKEN_DURATION_MINUTES);
        String token = Jwts.builder()
                .setSubject(user.getId())
                .claim(JwtConstants.CLAIMS_ROLES_KEY, user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();

        return new TokenDto(token, expirationDate.getTime());
    }
}

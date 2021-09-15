package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.TokenDto;
import com.inception.paycrypt.model.User;
import com.inception.paycrypt.service.AuthService;
import com.inception.paycrypt.utils.UserRoles;
import com.inception.paycrypt.utils.constants.JwtConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;

public class AuthServiceJwt implements AuthService {

    @Value("${app.secret}")
    private String JwtSecret;


    @Override
    public TokenDto generateToken(User user) {

        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, JwtConstants.TOKEN_DURATION_MINUTES);
        String token = Jwts.builder()
                .setSubject(user.getId())
                .claim(JwtConstants.CLAIMS_ROLES_KEY, UserRoles.USER) //TODO User model needs a role
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, JwtSecret)
                .compact();

        return new TokenDto(token, expirationDate.getTime());
    }
}

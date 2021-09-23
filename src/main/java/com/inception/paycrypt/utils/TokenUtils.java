package com.inception.paycrypt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.DatatypeConverter;

public class TokenUtils {

    public static String extractUserId(String token) {

        String JWT_TEST_SECRET = System.getenv("SECRET");
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(JWT_TEST_SECRET))
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}

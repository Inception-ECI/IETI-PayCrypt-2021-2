package com.inception.paycrypt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.xml.bind.DatatypeConverter;

/**
 * Utils for tokens
 *
 * @author Daniel Rincón
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenUtils {

    /**
     * Extracts user id from token
     *
     * @param token The token
     * @return The user id
     */
    public static String extractUserId(String token) {

        String JWT_TEST_SECRET = System.getenv("SECRET");
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(JWT_TEST_SECRET))
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}

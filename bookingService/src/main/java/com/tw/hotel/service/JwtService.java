package com.tw.hotel.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String SECRET;

    public void validateToken(String token) {
        // If any check fails (Signature, Expired, Malformed), it throws an exception
        extractAllClaims(token);
    }

    private void extractAllClaims(String token) {
        Jwts.parser()
                .verifyWith(getSignInKey());
//                .build()
//                .parseSignedClaims(token);
//                .getPayload();
    }

    private SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

}

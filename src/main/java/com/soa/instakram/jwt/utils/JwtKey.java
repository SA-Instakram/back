package com.soa.instakram.jwt.utils;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtKey {
    public static Key SECRET_KEY;
    public JwtKey(@Value("${jwt.secretKey}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        SECRET_KEY = Keys.hmacShaKeyFor(keyBytes);
    }
}

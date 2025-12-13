package com.springbootpractice.UserRegisteration.Util;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    // 1. THE SECRET KEY
    // In production, this should be an extremely complex string stored in environment variables.
    // This specific key is a Base64 encoded 256-bit key.

    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    // 2. GENERATE TOKEN
    // This is the method you will call from your Controller or Service
    public static String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    // 3. CREATE TOKEN LOGIC
    private static String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims) // Add any custom data (roles, email, etc.)
                .setSubject(userName) // The person this token is for
                .setIssuedAt(new Date(System.currentTimeMillis())) // When was it made?
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Expires in 30 minutes
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // Sign it with our secret
                .compact();
    }

    // 4. GET KEY
    // Decodes our secret string into a cryptographic key object
    private static Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

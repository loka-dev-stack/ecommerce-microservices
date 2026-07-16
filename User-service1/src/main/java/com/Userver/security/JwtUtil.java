package com.Userver.security;

import java.util.Date;


import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {

	
	 private static final String SECRET_KEY =
	            "mysecretkeymysecretkeymysecretkey123456";

	 private final SecretKey key =
		        Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	    public String generateToken(String email) {

	        return Jwts.builder()
	                .subject(email)
	                .issuedAt(new Date())
	                .expiration(new Date(System.currentTimeMillis() + 86400000))
	                .signWith(key)
	                .compact();
	    }
	    
	    public String extractUsername(String token) {
	        return Jwts.parser()
	                .verifyWith( key)
	                .build()
	                .parseSignedClaims(token)
	                .getPayload()
	                .getSubject();
	    }
	    
	    public Date extractExpiration(String token) {
	        return Jwts.parser()
	                .verifyWith((SecretKey) key)
	                .build()
	                .parseSignedClaims(token)
	                .getPayload()
	                .getExpiration();
	    }
	    
	    public boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
	    
	    public boolean validateToken(String token, String email) {

	        String username = extractUsername(token);

	        return username.equals(email) && !isTokenExpired(token);
	    }
}

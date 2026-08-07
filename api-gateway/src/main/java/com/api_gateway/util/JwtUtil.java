package com.api_gateway.util;

import com.api_gateway.constant.AppConstants;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtil {
    
	 private final SecretKey key =
	            Keys.hmacShaKeyFor(AppConstants.SECRET_KEY.getBytes());

	    // Extract Username (Email)
	    public String extractUsername(String token) {

	        return getClaims(token).getSubject();
	    }

	    // Extract Expiration Date
	    public Date extractExpiration(String token) {

	        return getClaims(token).getExpiration();
	    }

	    // Check Token Expiration
	    public boolean isTokenExpired(String token) {

	        return extractExpiration(token).before(new Date());
	    }

	    // Validate Token
	    public boolean validateToken(String token) {

	        return !isTokenExpired(token);
	    }

	    // Extract Claims
	    private Claims getClaims(String token) {

	        return Jwts.parser()
	                .verifyWith(key)
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }
}

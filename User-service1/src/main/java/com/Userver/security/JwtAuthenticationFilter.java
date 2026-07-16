package com.Userver.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private JwtUtil jutil;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain filterChain)
	        throws ServletException, IOException {

	    String authHeader = request.getHeader("Authorization");

	    String jwt = null;
	    String email = null;

	    if (authHeader != null && authHeader.startsWith("Bearer ")) {
	        jwt = authHeader.substring(7);
	        email = jutil.extractUsername(jwt);
	        System.out.println("Email from token: " + email);
	    }

	    if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(email);

	        if (jutil.validateToken(jwt, userDetails.getUsername())) {
	        	System.out.println("Token is valid");

	            UsernamePasswordAuthenticationToken authentication =
	                    new UsernamePasswordAuthenticationToken(
	                            userDetails,
	                            null,
	                            userDetails.getAuthorities());

	            authentication.setDetails(
	                    new WebAuthenticationDetailsSource().buildDetails(request));

	            SecurityContextHolder.getContext().setAuthentication(authentication);
	            System.out.println("Authentication set successfully");
	        }
	    }

	    filterChain.doFilter(request, response);
	}

}

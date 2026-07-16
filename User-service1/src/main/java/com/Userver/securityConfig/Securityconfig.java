package com.Userver.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Userver.security.JwtAuthenticationFilter;
@Configuration
@EnableMethodSecurity
public class Securityconfig {
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http)throws Exception{
		 http.csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
             .requestMatchers("/api/users/register", "/api/users/login","/v3/api-docs/**","/swagger-ui/**",
                     "/swagger-ui.html")
             .permitAll()
             .anyRequest()
             .authenticated()
         ).addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		 return http.build();
		
	}

}

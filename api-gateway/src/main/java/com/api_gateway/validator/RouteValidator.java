package com.api_gateway.validator;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	public static final List<String> OPEN_API_ENDPOINTS = List.of(
            "/User-service1/api/users/login",
            "/User-service1/users/register"
    );
	
	  public Predicate<ServerHttpRequest> isSecured =
	            request -> OPEN_API_ENDPOINTS
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
	

}

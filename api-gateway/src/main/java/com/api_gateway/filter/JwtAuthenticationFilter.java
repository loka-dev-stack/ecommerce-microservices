package com.api_gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.api_gateway.util.JwtUtil;
import com.api_gateway.validator.RouteValidator;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(org.springframework.web.server.ServerWebExchange exchange,
                             org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

    	System.out.println("Path : " + exchange.getRequest().getURI().getPath());
        System.out.println("Is Secured : " + routeValidator.isSecured.test(exchange.getRequest()));


        if (routeValidator.isSecured.test(exchange.getRequest())) {

            String authHeader =
                    exchange.getRequest()
                            .getHeaders()
                            .getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {

                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

                return exchange.getResponse().setComplete();
            }

            String token = authHeader.substring(7);

            try {

                if (!jwtUtil.validateToken(token)) {

                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

                    return exchange.getResponse().setComplete();
                }

            } catch (Exception e) {

                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

                return exchange.getResponse().setComplete();

            }

        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
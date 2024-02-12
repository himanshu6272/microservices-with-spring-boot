package com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p.path("/user/**").uri("lb://user-service")).build();
    }
}

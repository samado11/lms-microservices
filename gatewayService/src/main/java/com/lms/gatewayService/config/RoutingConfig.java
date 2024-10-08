package com.lms.gatewayService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    @Autowired
    JwtFilter filter;
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/reportingAnalytics/**")
                        .filters(f -> f.filter(filter))
                    .uri("http://localhost:8082"))

                .route("path_route", r -> r.path("/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083"))
            .build();
    }
}

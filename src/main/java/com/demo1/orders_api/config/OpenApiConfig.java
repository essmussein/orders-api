package com.demo1.orders_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .info(new Info()
                .title("Orders API")
                .version("1.0.0")
                .description("Mini project for portfolio: Spring Boot + REST + JPA + PostgreSQL + Docker + Tests"));
    }
}

package com.nonstop.playground.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "논스톱 플레이그라운드 API",
                description = "논스톱 보드게임 동아리 플레이그라운드 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"api/v1/**"};

        return GroupedOpenApi.builder()
                .group("논스톱 플레이그라운드 API v1")
                .pathsToMatch(paths)
                .build();
    }
}

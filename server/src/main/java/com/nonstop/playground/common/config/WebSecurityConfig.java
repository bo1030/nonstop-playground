package com.nonstop.playground.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private static final String REGISTER_URL = "/users/*/user";
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/api-docs/**",
            "/swagger-ui/**",
            "/users/*/user/duplicate"
    };

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(HttpMethod.POST, REGISTER_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .disable()
                .csrf()
                .disable()
                .headers()
                .disable()
                .httpBasic()
                .disable()
                .rememberMe()
                .disable()
                .logout()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return httpSecurity.build();
    }
}

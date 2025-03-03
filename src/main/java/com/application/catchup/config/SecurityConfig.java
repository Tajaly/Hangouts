package com.application.catchup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {

        chainBuilder.authorizeHttpRequests(
                configurer -> configurer.anyRequest().authenticated()).csrf(AbstractHttpConfigurer ::disable).oauth2Login(Customizer.withDefaults());

        return chainBuilder.build();
    }
}

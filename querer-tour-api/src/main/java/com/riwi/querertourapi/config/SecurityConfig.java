package com.riwi.querertourapi.config;

import com.riwi.querertourapi.utils.enums.RoleUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] PUBLIC_URLS = {"/public/**", "/auth/**" };
    private final String[] ADMIN_URLS = {"/admin/**", "/company/**" };
    private final String[] COMPANY_URLS = {"/company/**", "/companyBranch/**" };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                // If an error is here v
                .csrf(AbstractHttpConfigurer::disable) // Disable csrf
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers(ADMIN_URLS).hasAuthority(RoleUser.ADMIN.name())
                        .requestMatchers(COMPANY_URLS).hasAuthority(RoleUser.COMPANY.name())
                        .requestMatchers(PUBLIC_URLS).permitAll() // Config public urls
                        .anyRequest().authenticated()
                ).build();
    }

}

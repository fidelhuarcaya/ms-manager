package org.copper.manager.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.copper.manager.jwt.JwtAuthenticatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final AuthenticationProvider authProvider;
    private final JwtAuthenticatorFilter jwtAuthenticatorFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest->
                        authRequest.requestMatchers("/api/auth/login", "/api/auth/register")
                                .permitAll()
                                .anyRequest()
                                .authenticated()

                )
                .sessionManagement(sessionManagement->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticatorFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling->{
                    exceptionHandling.authenticationEntryPoint((request, response, authException) -> {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error de autenticación: " + authException.getMessage());

                    });
                    exceptionHandling.accessDeniedHandler((request, response, accessDeniedException) -> {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Acceso denegado: " + accessDeniedException.getMessage());
                    });
                })

                .build();
    }
}
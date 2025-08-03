package com.neto.CarDealership.config;

import com.neto.CarDealership.auth.JwtAuthentication;
import com.neto.CarDealership.service.JwtService;
import com.neto.CarDealership.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthentication jwtAuthentication;

    public SecurityConfig(JwtAuthentication jwtAuthentication, MyUserDetailsService myUserDetailsService) {
        this.jwtAuthentication = jwtAuthentication;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/clients/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/clients/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/clients/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/clients/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .sessionManagement((sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public MyUserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder()); // esse ainda é válido
        return new ProviderManager(provider);
    }
}

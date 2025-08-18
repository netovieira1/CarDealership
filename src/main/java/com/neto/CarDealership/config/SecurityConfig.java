package com.neto.CarDealership.config;

import com.neto.CarDealership.user.auth.JwtAuthentication;
import com.neto.CarDealership.user.service.JwtService;
import com.neto.CarDealership.user.service.MyUserDetailsService;
import jakarta.servlet.Filter;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public JwtAuthentication jwtAuthentication(JwtService jwtService, MyUserDetailsService userDetailsService){
        return new JwtAuthentication(jwtService, userDetailsService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthentication jwtAuthentication) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/login", "/error").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/**", "/client/**", "/cars/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/**", "/client/**", "/cars/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/user/**", "/client/**", "/cars/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/user/**", "/client/**", "/cars/**").hasRole("ADMIN")
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
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }
}

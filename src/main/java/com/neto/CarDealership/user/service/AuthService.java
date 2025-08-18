package com.neto.CarDealership.user.service;

import com.neto.CarDealership.user.dto.*;
import com.neto.CarDealership.user.enums.Role;
import com.neto.CarDealership.user.model.UserModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthService(MyUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtService jwtService, UserService userService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse login(AuthRequest request) {

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtService.generateToken(user);
            return new AuthResponse(token);
        } else {
            throw new RuntimeException("Crendenciais inválidas");
        }
    }

    public AuthResponse register(RegisterRequestDTO request) {
        UserResponseDTO created = userService.createUser(request);
        String token = jwtService.generateToken(created.getUsername());
        return new AuthResponse(token);
    }
}

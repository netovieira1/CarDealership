package com.neto.CarDealership.service;

import com.neto.CarDealership.user.Role;
import com.neto.CarDealership.user.UserModel;
import com.neto.CarDealership.user.dto.AuthRequest;
import com.neto.CarDealership.user.dto.AuthResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

public class AuthService {

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(MyUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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

    public void register(AuthRequest request) {
        UserModel newUser = new UserModel();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(Role.USER);

        userDetailsService.saveUser(newUser);
    }
}

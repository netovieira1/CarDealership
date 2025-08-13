package com.neto.CarDealership.user.service;

import com.neto.CarDealership.user.dto.UserDTO;
import com.neto.CarDealership.user.enums.Role;
import com.neto.CarDealership.user.model.UserModel;
import com.neto.CarDealership.user.dto.AuthRequest;
import com.neto.CarDealership.user.dto.AuthResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;

    public AuthService(MyUserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtService jwtService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userService = userService;
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
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());

        userService.createUser(userDTO);
    }
}

package com.neto.CarDealership.service;

import com.neto.CarDealership.user.UserModel;
import com.neto.CarDealership.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                List.of(authority)
        );
    }
}

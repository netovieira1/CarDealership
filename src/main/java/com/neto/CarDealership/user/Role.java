package com.neto.CarDealership.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}

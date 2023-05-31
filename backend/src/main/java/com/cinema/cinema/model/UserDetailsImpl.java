package com.cinema.cinema.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private final String username;
    private final String password;

    public UserDetailsImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(user.getUsername(), user.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // If you have roles or authorities associated with the user, you can return them here
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // Implement other methods of the UserDetails interface
    // such as isEnabled(), isAccountNonExpired(), isAccountNonLocked(), isCredentialsNonExpired()

    @Override
    public boolean isEnabled() {
        return true; // You can customize this based on your application's logic
    }


    @Override
    public boolean isAccountNonExpired() {
        return true; // You can customize this based on your application's logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can customize this based on your application's logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can customize this based on your application's logic
    }

}

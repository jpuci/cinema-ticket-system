package com.cinema.cinema.controller;

import com.cinema.cinema.authentication.JwtTokenUtil;
import com.cinema.cinema.model.UserLoginRequest;
import com.cinema.cinema.model.UserLoginResponse;
import com.cinema.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.cinema.cinema.model.User;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(), userLoginRequest.getPassword())
        );

        // If authentication is successful, generate JWT token
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(authentication);

        // Retrieve user details
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByUsername(userDetails.getUsername());

        // Return the JWT token and user details in the response
        UserLoginResponse response = new UserLoginResponse(token, user.getId(), user.getUsername());
        return ResponseEntity.ok(response);
    }
}
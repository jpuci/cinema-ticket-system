package com.cinema.cinema.controller;

import com.cinema.cinema.authentication.JwtTokenUtil;
import com.cinema.cinema.model.AuthenticationRequest;
import com.cinema.cinema.model.AuthenticationResponse;
import com.cinema.cinema.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true", allowedHeaders = "true")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService,
                          JwtTokenUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

//    @PostMapping("/api/auth/login")
//    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authenticationRequest.getUsername(),
//                            authenticationRequest.getPassword()
//                    )
//            );
//
//            // Generate JWT token
//            String token = jwtUtil.generateToken(authentication);
//
//            // Create authentication response
//            AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);
//
//            return ResponseEntity.ok(authenticationResponse);
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );

            System.out.println("!!!!!!username: ");
            System.out.println(authenticationRequest.getUsername());

            // Generate JWT token
            String token = jwtUtil.generateToken(authentication);

            // Create authentication response
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);

            // Persist the JWT token in a cookie
//            Cookie cookie = new Cookie("jwt", token);
//            cookie.setMaxAge(86400); // Set cookie expiry time (in seconds)
//            cookie.setHttpOnly(true);
//            cookie.setSecure(true);
//            response.setHeader("Set-Cookie",
//                    cookie.getName() + "=" + cookie.getValue() + "; Secure=false ; SameSite=None; MaxAge=86400; HttpOnly=false; path=/login");


            return ResponseEntity.ok(authenticationResponse);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/api/auth/logout")
    public ResponseEntity<?> logout(@CookieValue(name = "jwt", required = false) String token, HttpServletResponse response) {
        // Delete the JWT token cookie
        if (token != null) {
            Cookie cookie = new Cookie("jwt", null);
            cookie.setMaxAge(0);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }

        return ResponseEntity.ok("Logged out successfully");
    }
}

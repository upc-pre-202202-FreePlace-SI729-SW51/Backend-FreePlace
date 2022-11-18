package com.acme.freeplace.auth.controller;


import com.acme.freeplace.auth.resource.JwtResponse;
import com.acme.freeplace.auth.resource.LoginResource;
import com.acme.freeplace.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class LoginController {
    private final AuthenticationManager manager;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController( AuthenticationManager manager, JwtUtil jwtUtil) {
        this.manager = manager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginResource user){
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

}

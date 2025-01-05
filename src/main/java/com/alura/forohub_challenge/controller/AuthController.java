package com.alura.forohub_challenge.controller;

import com.alura.forohub_challenge.infra.security.JwtTokenData;
import com.alura.forohub_challenge.infra.security.TokenService;
import com.alura.forohub_challenge.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private ServiceUser serviceUser;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUser createUser) {
        var datos = serviceUser.registerUser(createUser);
        return ResponseEntity.ok("User successfully registered.");
    }

    @PostMapping
    public ResponseEntity autentificarUsuario(@RequestBody AuthUser authUser) {
        Authentication authtoken = new UsernamePasswordAuthenticationToken(authUser.username(), authUser.password());
        var userAuth= authenticationManager.authenticate(authtoken);
        var jwtToken = tokenService.generateToken((User) userAuth.getPrincipal());
        return ResponseEntity.ok(new JwtTokenData(jwtToken));
    }


}

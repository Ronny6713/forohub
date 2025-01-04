package com.alura.forohub_challenge.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserData registerUser(CreateUser createUser) {
        var user = new User(createUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var data = new UserData(user.getUsername());
        return (data);
    }


}

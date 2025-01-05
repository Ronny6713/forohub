package com.alura.forohub_challenge.user;

import com.alura.forohub_challenge.domain.Topic.Topic;
import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import org.flywaydb.core.internal.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserData registerUser(CreateUser createUser) {
        boolean userExist = userRepository.existsByUsername(createUser.username());
        if (userExist) {
            throw new ValidationExceptionApi("Username is already in use.");
        }
        validatePassword(createUser.password());
        var user = new User(createUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var data = new UserData(user.getUsername());
        return (data);
    }


    public void validatePassword(String password) {
        if (password.length() < 7) {
            throw new IllegalArgumentException("Password must be at least 7 characters long.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one number.");
        }
    }
}

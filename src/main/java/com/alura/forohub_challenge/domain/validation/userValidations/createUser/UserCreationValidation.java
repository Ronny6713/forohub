package com.alura.forohub_challenge.domain.validation.userValidations.createUser;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.user.CreateUser;
import com.alura.forohub_challenge.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreationValidation implements  IValidationCreateUser{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void validation(CreateUser createUser) {
        boolean userExist = userRepository.existsByUsername(createUser.username());
        if (userExist) {
            throw new ValidationExceptionApi("Username is already in use.");
        }
        if (createUser.password().length() < 7) {
            throw new IllegalArgumentException("Password must be at least 7 characters long.");
        }
        if (!createUser.password().matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!createUser.password().matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!createUser.password().matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one number.");
        }
    }
}

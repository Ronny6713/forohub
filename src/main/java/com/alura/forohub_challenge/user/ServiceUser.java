package com.alura.forohub_challenge.user;

import com.alura.forohub_challenge.domain.ValidationExceptionApi;
import com.alura.forohub_challenge.domain.validation.courseValidation.updateCourse.IValidationUpdateCourse;
import com.alura.forohub_challenge.domain.validation.userValidations.createUser.IValidationCreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private List<IValidationCreateUser> valdationCreateUser;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserData registerUser(CreateUser createUser) {
        valdationCreateUser.forEach(v -> v.validation(createUser));
        var user = new User(createUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var data = new UserData(user.getUsername());
        return (data);
    }

}

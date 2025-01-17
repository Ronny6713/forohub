package com.alura.forohub_challenge.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository <User, Long> {

    UserDetails findByUsername(String username);

    boolean existsByUsername(String username);

}

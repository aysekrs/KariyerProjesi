package com.example.careercounseling.service;

import com.example.careercounseling.dto.RegistrationRequest;
import com.example.careercounseling.entity.User;
import com.example.careercounseling.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(RegistrationRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // In a real app, encode the password.
        user.setRole(request.getRole());

        return userRepository.save(user);
    }
}

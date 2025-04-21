package com.example.teaching.service;

import com.example.teaching.entity.User;
import com.example.teaching.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        // Check if the user exists
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null; // Or throw an exception
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
}
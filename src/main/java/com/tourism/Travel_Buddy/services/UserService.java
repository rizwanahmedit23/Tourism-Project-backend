package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User updateUser(User user, String id) {
        User existingUser = userRepo.findByEmail(id);
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setMobile(user.getMobile());
        existingUser.setEmail(user.getEmail());
        User updatedProduct = userRepo.save(existingUser);
        return updatedProduct;
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> getAllUser() {
        return userRepo.findAllUser();
    }
}

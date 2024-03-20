package com.tourism.Travel_Buddy.services;

import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //---------------------------------Register Admin-------------------------------------------------
        public void initRoleAndUser(){
        User adminUser = new User();
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword(passwordEncoder.encode("admin123"));
        adminUser.setRole("ADMIN");
        userRepo.save(adminUser);
    }

    //---------------------------------Register User-------------------------------------------------
    public User registerUser(User user) {
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


}

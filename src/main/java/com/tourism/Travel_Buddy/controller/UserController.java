package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String welcomeUser() {
        System.out.println("welcome");
        return "Welcome";
    }

 //-------------------------Register user---------------------------------------------
       //register done in home controller

    //--------------------------Get user by id-------------------------------------------
    @GetMapping("/getUser/email/{email}")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    //--------------------------Get user by id-------------------------------------------
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    //------------------------update user details---------------------------------------
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user,@RequestParam("id") String id) {
        return userService.updateUser(user,id);

    }


}

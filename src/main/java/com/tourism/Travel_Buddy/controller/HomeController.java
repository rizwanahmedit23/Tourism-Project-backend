package com.tourism.Travel_Buddy.controller;

import com.tourism.Travel_Buddy.config.JWTHelper;
import com.tourism.Travel_Buddy.model.*;
import com.tourism.Travel_Buddy.repository.UserRepo;
import com.tourism.Travel_Buddy.services.HomeService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTHelper helper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;


    private Logger logger = LoggerFactory.getLogger(HomeController.class);


    @PostMapping("/loginAccount")
   public JWTResponse login(@RequestBody JWTRequest request){
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(request.getEmail());

        return new JWTResponse(token,request.getEmail(),userRepo.getRoleByEmail(request.getEmail()));
    }

    private void doAuthenticate(String email,String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);
        try {
            authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException e){
            throw new RuntimeException("Invalid Username or Password !!");
        }
    }


    //-------------------------Register user---------------------------------------------
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        System.out.println("register");
        return homeService.registerUser(user);
    }


    //@PostMapping("/registerAdmin")
    @PostConstruct
    public void initRoleAndUser() {
        System.out.println("init method");
        homeService.initRoleAndUser();
    }

}

package com.tourism.Travel_Buddy.config;

import com.tourism.Travel_Buddy.model.User;
import com.tourism.Travel_Buddy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repo.findByEmail(username);
        if (user != null) {
            List<GrantedAuthority> authorities = Arrays.stream(user.getRole().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                   authorities
            );
         }
          else {
            throw new UsernameNotFoundException("user not found with username: " + username);
        }
    }


}

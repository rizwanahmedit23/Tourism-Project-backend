package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    //User findById(String email);

    @Query("SELECT u FROM User u WHERE u.email != 'admin@gmail.com'")
    List<User> findAllUser();

    @Override
    Optional<User> findById(String s);


    User findByEmail(String email);

    @Query("SELECT u.role FROM User u WHERE u.email = ?1")
    String getRoleByEmail(String email);
}

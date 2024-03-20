package com.tourism.Travel_Buddy.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {

    @Id
    private String email;
    private String name;
    private String address;
    private String mobile;
    private String gender;
    private String password;

    private String role;


    public User() {
    }

    public User(String email, String name, String address, String mobile, String gender, String password, String role) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.gender = gender;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + role+
                '}';
    }
}

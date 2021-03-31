package com.flipkart.bean;

import com.flipkart.constants.Role;

public class User {
    private String name;
    private String email;
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(String name,String email,Role role){
        this.email = email;
        this.name = name;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getUserID() {
//        return userID;
//    }
//
//    public void setUserID(String userID) {
//        this.userID = userID;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

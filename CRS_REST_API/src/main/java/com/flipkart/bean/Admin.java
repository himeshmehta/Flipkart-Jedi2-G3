package com.flipkart.bean;

import com.flipkart.constants.Role;

public class Admin extends User {

    public Admin(String name, String email, Role role, int userId) {
        super(name, email, role,userId);
    }

    public Admin(User user){
        super(user.getName(), user.getEmail(), user.getRole(), user.getUserId());
    }
}

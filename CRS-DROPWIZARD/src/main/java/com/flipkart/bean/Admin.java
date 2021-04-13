package com.flipkart.bean;

import com.flipkart.constants.RoleEnum;

public class Admin extends User {

    public Admin(String name, String email, RoleEnum roleEnum, int userId) {
        super(name, email, roleEnum,userId);
    }

    public Admin(User user){
        super(user.getName(), user.getEmail(), user.getRole(), user.getUserId());
    }
}

package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constants.Role;

public class AuthDB {

    public static User AuthenticateUser(String userId, String password){
        User user = new User("Himesh", "himesh@gmail.com",Role.ADMIN);
        // user.setRole(Role.ADMIN);
        return user;
    }

    public static Boolean addNewUser(User user,String password){
        return Boolean.TRUE;
    }

    public static Boolean removeExistingUser(User user){
        return Boolean.TRUE;
    }
}

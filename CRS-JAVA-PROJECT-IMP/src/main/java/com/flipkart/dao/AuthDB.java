package com.flipkart.dao;

import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.exception.AuthorizationException;

public class AuthDB {

    public static User AuthenticateUser(String userId, String password) throws AuthorizationException {


               User user = new User("Himesh", "himesh@gmail.com", Role.ADMIN);
               // user.setRole(Role.ADMIN);
        if(!user.getEmail().equals(userId))
        throw  new AuthorizationException("Invalid Credentials");
               return user;




    }

    public static Boolean addNewUser(User user,String password){
        return Boolean.TRUE;
    }

    public static Boolean removeExistingUser(User user){
        return Boolean.TRUE;
    }

    public static Boolean approveStudent(String studentId){

        return Boolean.TRUE;
    }
}

package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;

public class AuthDB implements AuthDBInterface{

    public  User AuthenticateUser(String userId, String password) throws AuthorizationException {

        User user = new User("Himesh", "himesh@gmail.com", Role.ADMIN,"101");
        // user.setRole(Role.ADMIN);
        if(!user.getUserId().equals(userId))
                throw  new AuthorizationException("Invalid Credentials");

        return user;

    }

    public  Boolean addNewUser(User user,String password){
        return Boolean.TRUE;
    }

    public  Boolean removeExistingUser(User user){
        return Boolean.TRUE;
    }

    public  Boolean approveStudent(String studentId){
        return Boolean.TRUE;
    }

    @Override
    public Boolean selfRegisterStudent(String email, String name, String password) {
        return Boolean.TRUE;
    }


}

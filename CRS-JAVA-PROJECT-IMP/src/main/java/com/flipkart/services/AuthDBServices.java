package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.dao.AuthDB;

import javax.jws.soap.SOAPBinding;

public class AuthDBServices implements AuthDBInterface{

    @Override
    public User authenticateUser(String userId, String password) {
        User user = AuthDB.AuthenticateUser(userId,password);
        return user;
    }
}

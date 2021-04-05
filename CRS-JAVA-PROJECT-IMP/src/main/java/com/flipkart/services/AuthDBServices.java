package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;
import com.flipkart.exception.AuthorizationException;

import java.util.logging.Logger;


public class AuthDBServices implements AuthDBInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(AuthDBServices.class));

    @Override
    public User authenticateUser(String userId, String password) throws AuthorizationException {

        User user = AuthDB.AuthenticateUser(userId,password);
        logger.info("Authenticating User");
        return user;
    }
}

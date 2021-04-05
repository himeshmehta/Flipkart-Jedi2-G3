package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.InvalidInputException;
import com.flipkart.bean.User;

public interface AuthDBInterface  {

    /**
     *
     This method is used to authenticate the User from the Database.
     @Param - userId , password
     @Throws - AuthorizationException
     @returns - User

     **/
    public User authenticateUser(String userId, String password) throws AuthorizationException;
    public void selfRegistration(User user) throws InvalidInputException;
}
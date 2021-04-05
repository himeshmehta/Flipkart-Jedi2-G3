package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.exception.AuthorizationException;

public interface AuthDBInterface  {

    /**
     *
     This method is used to authenticate the User from the Database.
     @Param - userId , password
     @Throws - AuthorizationException
     @returns - User

     **/
    public User authenticateUser(String userId, String password) throws AuthorizationException;
}
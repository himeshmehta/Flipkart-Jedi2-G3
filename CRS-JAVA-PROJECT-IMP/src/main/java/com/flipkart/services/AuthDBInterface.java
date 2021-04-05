package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.InvalidInputException;
import com.flipkart.bean.User;

public interface AuthDBInterface  {

    public User authenticateUser(String userId, String password) throws AuthorizationException;
    public void selfRegistration(User user) throws InvalidInputException;
}
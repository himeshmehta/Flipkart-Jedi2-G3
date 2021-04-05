package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.exception.AuthorizationException;

public interface AuthDBInterface  {

    public User authenticateUser(String userId, String password) throws AuthorizationException;
}
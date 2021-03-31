package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.constants.Role;

public interface AuthDBInterface {
    public User authenticateUser(String userId, String password);
}
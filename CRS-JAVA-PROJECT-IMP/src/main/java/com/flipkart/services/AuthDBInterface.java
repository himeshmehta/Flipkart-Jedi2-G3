package com.flipkart.services;

import com.flipkart.Exception.InvalidInputException;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;

public interface AuthDBInterface {
    public User authenticateUser(String userId, String password);
    public void selfRegistration(User user) throws InvalidInputException;
}
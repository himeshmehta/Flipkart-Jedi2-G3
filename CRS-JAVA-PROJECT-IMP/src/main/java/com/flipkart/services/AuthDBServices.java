package com.flipkart.services;

import com.flipkart.Exception.InvalidInputException;
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

    @Override
    public void selfRegistration(User user) throws InvalidInputException {
        // This method is only applicable for student
        if(!Role.STUDENT.equals(user.getRole())){
            throw new InvalidInputException("Only student can self register.");
        }
    }
}

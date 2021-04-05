package com.flipkart.helper;

import com.flipkart.Exception.InvalidDataException;
import com.flipkart.Exception.InvalidPasswordException;

public class UserValidator {

    public static void emailValidator(String userId) throws InvalidDataException {

        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result = userId.matches(regex);
        if(!result){
            throw new InvalidDataException("Please provide a valid email");
        }
    }

    public static void passwordValidator(String password) throws InvalidPasswordException{
        if (password.length() < 8 || password.length() > 16) {
            throw new InvalidPasswordException("Password length should be between 8 and 16");
        }
    }
}

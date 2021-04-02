package com.flipkart.helper;

import com.flipkart.Exception.InvalidDataException;

public class UserValidator {

    public static void emailValidator(String userId) throws InvalidDataException {

        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result = userId.matches(regex);
        if(!result){
            throw new InvalidDataException("Please provide a valid email");
        }
    }
}

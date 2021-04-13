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

    public static void selfRegisterValidator(String email, String password, String confirmPassword) throws InvalidDataException {
        emailValidator(email);
        passwordStrengthValidator(password);
        if(confirmPassword  == null || !confirmPassword.equals(password)){
            throw new InvalidDataException("Your confirm password do not match with actual password");
        }
    }

    public static void passwordStrengthValidator(String password) throws InvalidDataException {
        if(password == null || password.length() < 5){
            throw new InvalidDataException("Weak password. Password should contain minimum 5 digits.");
        }
    }

    public static void newUsedValidator(String email,String password) throws InvalidDataException {
        emailValidator(email);
        passwordStrengthValidator(password);
    }
}

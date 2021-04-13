package com.flipkart.src.main.java.com.flipkart.helper;

import com.flipkart.Exception.InvalidDataException;

/**
 * The type user validator
 */
public class UserValidator {

    /**
     * This method is used to validate email
     * @param userId
     * @throws InvalidDataException
     */
    public static void emailValidator(String userId) throws InvalidDataException {

        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result = userId.matches(regex);
        if(!result){
            throw new InvalidDataException("Please provide a valid email");
        }
    }

    /**
     * This method is used to validate user
     * @param email
     * @param password
     * @param confirmPassword
     * @throws InvalidDataException
     */
    public static void selfRegisterValidator(String email, String password, String confirmPassword) throws InvalidDataException {
        emailValidator(email);
        passwordStrengthValidator(password);
        if(confirmPassword  == null || !confirmPassword.equals(password)){
            throw new InvalidDataException("Your confirm password do not match with actual password");
        }
    }

    /**
     * This method is used to validate password strength
     * @param password
     * @throws InvalidDataException
     */
    public static void passwordStrengthValidator(String password) throws InvalidDataException {
        if(password == null || password.length() < 5){
            throw new InvalidDataException("Weak password. Password should contain minimum 5 digits.");
        }
    }

    /**
     * This method is used to validate user by checking email and password
     * @param email
     * @param password
     * @throws InvalidDataException
     */
    public static void newUsedValidator(String email,String password) throws InvalidDataException {
        emailValidator(email);
        passwordStrengthValidator(password);
    }
}

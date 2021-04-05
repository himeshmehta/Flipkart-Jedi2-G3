package com.flipkart.Exception;

public class InvalidInputException extends Exception{
    // Usage :- when input is not associated with given entity

    public InvalidInputException(String message){
        super(message);
    }
}

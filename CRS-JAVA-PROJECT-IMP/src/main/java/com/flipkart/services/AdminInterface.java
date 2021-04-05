package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyAddedException;
import com.flipkart.exception.UserNotPresetException;

public interface AdminInterface {

    /**
     *
     This method is used to Add the User to the Database.
     @Param - User , password
     @Throws - UserAlreadyAddedException
     @returns - Boolean

     **/
    public Boolean addUser(User user, String password) throws UserAlreadyAddedException;

    /**
     *
     This method is used to removes the User to the Database.
     @Param - User
     @Throws - UserNotPresetException
     @returns - Boolean

     **/
    public Boolean removeUser(User user) throws UserNotPresetException;
}

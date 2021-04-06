package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.bean.User;

public interface AdminInterface {

    /**
     *
     This method is used to Add the User to the Database.
     @Param - User , password
     @Throws - UserAlreadyAddedException
     @returns - Boolean

    public Boolean removeUser(User user);

    public Boolean approveStudent(String studentId) throws ApprovalFailedException;
     **/
    public Boolean addUser(User user, String password);

    /**
     *
     This method is used to removes the User to the Database.
     @Param - User
     @Throws - UserNotPresetException
     @returns - Boolean

     **/
    public Boolean removeUser(User user);

    /**
     *
     This method is used to approve the Student.
     @Param - studentId
     @Throws - ApprovalFailedException
     @returns - Boolean

     **/
    public Boolean approveStudent(final String studentId) throws ApprovalFailedException;
}

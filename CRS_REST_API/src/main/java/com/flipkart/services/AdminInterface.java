package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.User;

import java.util.List;

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
    public Boolean addUser(User user, String password) throws CRSException, InvalidDataException;

    /**
     *
     This method is used to removes the User to the Database.
     @Param - UserId
     @Throws - UserNotPresetException
     @returns - Boolean

     **/
    public void removeUser(int userId) throws CRSException;

    /**
     *
     This method is used to approve the Student.
     @Param - studentId
     @Throws - ApprovalFailedException
     @returns - Boolean

     **/
    public void approveStudent(final int studentId) throws ApprovalFailedException, CRSException;

    public List<Integer> getNotApprovedStudents() throws CRSException;

    public void addNewCourse(String description,String courseName, long fee) throws CRSException;
}

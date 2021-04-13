package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;

import java.util.List;

public interface AdminInterface {

    /**
     *
     This method is used to Add the User to the Database.
     @Param - User , password
     @Throws - UserAlreadyAddedException,CRSException,InvalidDataException
     @returns - User object

     **/
    public User addUser(User user, String password) throws CRSException, InvalidDataException;

    /**
     *
     This method is used to removes the User to the Database.
     @Param - UserId
     @Throws - CRSException
     @returns - Boolean

     **/
    public void removeUser(int userId) throws CRSException;

    /**
     *
     This method is used to approve the Student.
     @Param - studentId
     @Throws - ApprovalFailedException,CRSException
     @returns - Boolean

     **/
    public void approveStudent(final int studentId) throws ApprovalFailedException, CRSException;

    /**
     *
     This method is used to get list of students who are not approved yet.
     @Param - User , password
     @Throws - CRSException
     @returns - List of studentId

     **/
    public List<Integer> getNotApprovedStudents() throws CRSException;

    /**
     *
     This method is used to Add new course in system
     @Param - course_description , courseName, courseFee
     @Throws - CRSException
     @returns - Course object

     **/
    public Course addNewCourse(String description, String courseName, long fee) throws CRSException;
}

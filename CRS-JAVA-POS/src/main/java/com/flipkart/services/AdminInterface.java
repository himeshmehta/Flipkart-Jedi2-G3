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
     @param - User , password
     @throws - UserAlreadyAddedException,CRSException,InvalidDataException
     @return - User object

     **/
    public User addUser(User user, String password) throws CRSException, InvalidDataException;

    /**
     *
     This method is used to removes the User to the Database.
     @param  - UserId
     @throws - CRSException
     @return - Boolean

     **/
    public void removeUser(int userId) throws CRSException;

    /**
     *
     This method is used to approve the Student.
     @param - studentId
     @throws - ApprovalFailedException,CRSException
     @return - Boolean

     **/
    public void approveStudent(final int studentId) throws ApprovalFailedException, CRSException;

    /**
     *
     This method is used to get list of students who are not approved yet.
     @param - User , password
     @throws - CRSException
     @return - List of studentId

     **/
    public List<Integer> getNotApprovedStudents() throws CRSException;

    /**
     *
     This method is used to Add new course in system
     @param - course_description , courseName, courseFee
     @throws - CRSException
     @return - Course object

     **/
    public Course addNewCourse(String description, String courseName, long fee) throws CRSException;
}

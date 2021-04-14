package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;

import java.util.List;

public interface AdminInterface {

    /**
     * This method is used to Add the User to the Database.
     * @param user user object
     * @param password user password
     * @throws CRSException crs exception
     * @throws InvalidDataException invalid data exception
     * @return user
     */
    public User addUser(User user, String password) throws CRSException, InvalidDataException;

    /**
     * This method is used to removes the User to the Database.
     * @param userId user id
     * @throws CRSException crs exception
     */
    public void removeUser(int userId) throws CRSException;

    /**
     * This method is used to approve the Student.
     * @param studentId student id
     * @throws ApprovalFailedException approval failed exception
     * @throws CRSException crs exception
     */
    public void approveStudent(final int studentId) throws ApprovalFailedException, CRSException;

    /**
     *  This method is used to get list of students who are not approved yet.
     * @throws CRSException crs exception
     * @return list
     */
    public List<Integer> getNotApprovedStudents() throws CRSException;

    /**
     * This method is used to Add new course in system
     * @param description course description
     * @param courseName course name
     * @param fee course fee
     * @throws CRSException crs exception
     * @return course
     */
    public Course addNewCourse(String description, String courseName, long fee) throws CRSException;
}

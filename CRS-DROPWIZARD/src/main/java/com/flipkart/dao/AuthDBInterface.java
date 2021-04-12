package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;

import java.util.List;

public interface AuthDBInterface {

    /**
     * This method is used to Authenticate User .
     * @Param userId :- id of user.
     * @Param password :- password of user.
     * @Throws AuthorizationException
     * @return User object
     */
    public User AuthenticateUser(int userId, String password) throws AuthorizationException;

    /**
     * This method is used by admin to add new user(student or professor or admin).
     * @Param user :- User object.
     * @Param password :- password of user.
     * @Throws CRSException
     * @return User object
     */
    public User addNewUser(User user, String password) throws CRSException;

    /**
     * This method is used by admin to remove existing user(student or professor).
     * @Param userId :- id of user.
     * @Throws CRSException
     * @return Nothing
     */
    public void removeExistingUser(int userId) throws CRSException;

    /**
     * This method is used by admin to approve registration of student.
     * @Param studentId :- studentId.
     * @Throws CRSException
     * @return Nothing
     */
    public void approveStudent(int studentId) throws CRSException;

    /**
     * This method is used for self registration of student and populate user and student table.
     * @Param email :- email of new student
     * @Param name :- name of new student
     * @Param password :- name of new student
     * @Throws CRSException
     * @returns User object
     */
    public User selfRegisterStudent(String email, String name, String password) throws CRSException;

    /**
     * This method is used to get user details except password.
     * @Param userId :- userId.
     * @Throws InvalidDataException, CRSException
     * @return User object containing email, name, role, userId.
     */
    public User getUserDetails(int userId) throws InvalidDataException, CRSException;

    /**
     * This method is used to get list of student ids which are not approved yet.
     * @Param Nothing
     * @Throws CRSException
     * @return List of student ids
     */
    public List<Integer> getNotApprovedStudent() throws CRSException;

}

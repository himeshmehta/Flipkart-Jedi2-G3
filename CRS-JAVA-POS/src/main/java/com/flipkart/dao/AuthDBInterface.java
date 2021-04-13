package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.User;

import java.util.List;

public interface AuthDBInterface {

    /**
     * This method is used to Authenticate User .
     * @param userId :- id of user.
     * @param password :- password of user.
     * @throws AuthorizationException
     * @return User object
     */
    public User AuthenticateUser(int userId, String password) throws AuthorizationException;

    /**
     * This method is used by admin to add new user(student or professor or admin).
     * @param user :- User object.
     * @param password :- password of user.
     * @throws CRSException
     * @return User object
     */
    public User addNewUser(User user, String password) throws CRSException;

    /**
     * This method is used by admin to remove existing user(student or professor).
     * @param userId :- id of user.
     * @throws CRSException
     */
    public void removeExistingUser(int userId) throws CRSException;

    /**
     * This method is used by admin to approve registration of student.
     * @param studentId :- studentId.
     * @throws CRSException
     */
    public void approveStudent(int studentId) throws CRSException;

    /**
     * This method is used for self registration of student and populate user and student table.
     * @param email :- email of new student
     * @param name :- name of new student
     * @param password :- name of new student
     * @throws CRSException
     * @return User object
     */
    public User selfRegisterStudent(String email, String name, String password) throws CRSException;

    /**
     * This method is used to get user details except password.
     * @param userId :- userId.
     * @throws InvalidDataException, CRSException
     * @return User object containing email, name, role, userId.
     */
    public User getUserDetails(int userId) throws InvalidDataException, CRSException;

    /**
     * This method is used to get list of student ids which are not approved yet.
     * @throws CRSException
     * @return List of student ids
     */
    public List<Integer> getNotApprovedStudent() throws CRSException;

}

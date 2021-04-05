package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.bean.User;

public interface AuthDBInterface {

    /**
     * This method is used to Authenticate User .
     * @Param userId :- id of user.
     * @Param password :- password of user.
     * @Throws AuthorizationException
     * @return User object
     */
    public User AuthenticateUser(String userId, String password) throws AuthorizationException;

    /**
     * This method is used by admin to add new user(student or professor).
     * @Param user :- User object.
     * @Param password :- password of user.
     * @Throws AuthorizationException
     * @return Boolean
     */
    public Boolean addNewUser(User user,String password);

    /**
     * This method is used by admin to remove existing user(student or professor).
     * @Param user :- User object.
     * @Throws AuthorizationException
     * @return Boolean
     */
    public Boolean removeExistingUser(User user);

    /**
     * This method is used by admin to approve registration of student.
     * @Param studentId :- studentId.
     * @Throws AuthorizationException
     * @return Boolean
     */
    public Boolean approveStudent(String studentId);

    /**
     * This method is used for self registration of student and populate user table.
     * @Param email :- email of new student
     * @Param name :- name of new student
     * @Param password :- name of new student
     * @Throws Nothing
     * @returns Boolean
     */
    public Boolean selfRegisterStudent(String email, String name,String password);
}

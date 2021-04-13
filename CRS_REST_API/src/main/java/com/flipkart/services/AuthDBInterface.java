package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.bean.User;

public interface AuthDBInterface  {

    /**
     *
     This method is used to authenticate the User from the Database.
     @Param - userId , password
     @Throws - AuthorizationException
     @returns - User

     **/
    public User authenticateUser(int userId, String password) throws AuthorizationException;

    /**
     * This method is used by student for self registration. Once registration is complete then student must wait till he/she get approval from admin.
     * @Param email :- email of student
     * @Param name :- name of student
     * @Param password :- password enter by student
     * @Param confirmPassword :- confirm password enter by student
     * @Throws Nothing
     * @returns User object
     * */
    public User selfRegisterStudent(String email, String name, String password, String confirmPassword) throws CRSException;
}
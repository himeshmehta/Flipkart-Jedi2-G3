package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.bean.User;

public interface AuthDBInterface  {

    /**
     *
     This method is used to authenticate the User from the Database.
     @param - userId , password
     @throws - AuthorizationException
     @return - User

     **/
    public User authenticateUser(int userId, String password) throws AuthorizationException;

    /**
     * This method is used by student for self registration. Once registration is complete then student must wait till he/she get approval from admin.
     * @param email :- email of student
     * @param name :- name of student
     * @param password :- password enter by student
     * @param confirmPassword :- confirm password enter by student
     * @throws Nothing
     * @return User object
     * */
    public User selfRegisterStudent(String email, String name, String password, String confirmPassword) throws CRSException;
}
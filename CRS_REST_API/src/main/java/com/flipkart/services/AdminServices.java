package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;
import com.flipkart.helper.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class AdminServices implements AdminInterface{
    private AuthDB authDBOperations;
    NotificationServices notificationServices ;
    public AdminServices(){
        this.notificationServices = new NotificationServices();
        this.authDBOperations = new AuthDB();
    }


    private static final Logger logger = Logger.getLogger(String.valueOf(AdminServices.class));

    @Override
    public Boolean addUser(User user,String password) throws CRSException, InvalidDataException {
        UserValidator.newUsedValidator(user.getEmail(),password);
        Boolean isUserAdded = authDBOperations.addNewUser(user,password);
        logger.info("Adding User to the DB");
        return isUserAdded;
    }

    @Override
    public void removeUser(int user) throws CRSException {
        authDBOperations.removeExistingUser(user);
        logger.info("Removing User from the DB");
        return ;
    }

    @Override
    public void approveStudent(final int studentId) throws CRSException {
        try {
            authDBOperations.approveStudent(studentId);
            notificationServices.approvalNotifier(studentId);
        } catch (NotificationException ex){
            throw new CRSException(ex.getMessage());
        }
    }



    public List<Integer> getNotApprovedStudents() throws CRSException {
        List<Integer> result  = new ArrayList<Integer>();
        result = authDBOperations.getNotApprovedStudent();
        return result;
    }

    @Override
    public void addNewCourse(String description, String courseName, long fee) throws CRSException {

        logger.info("Adding new course");
        authDBOperations.addNewCourse(description,courseName,fee);
    }
}

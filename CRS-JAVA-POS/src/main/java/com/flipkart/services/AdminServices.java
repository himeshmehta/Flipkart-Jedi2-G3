package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;
import com.flipkart.dao.CourseDB;
import com.flipkart.helper.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class AdminServices implements AdminInterface{
    private AuthDB authDBOperations;
    private NotificationServices notificationServices ;
    private CourseDB courseDB;
    public AdminServices(){
        this.notificationServices = new NotificationServices();
        this.authDBOperations = new AuthDB();
        this.courseDB = new CourseDB();
    }


    private static final Logger logger = Logger.getLogger(String.valueOf(com.flipkart.services.AdminServices.class));

    @Override
    public User addUser(User user,String password) throws CRSException, InvalidDataException {
        UserValidator.newUsedValidator(user.getEmail(),password);
        User newUser = authDBOperations.addNewUser(user,password);
        logger.info("Adding User to the DB");
        return newUser;
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


    @Override
    public List<Integer> getNotApprovedStudents() throws CRSException {
        List<Integer> result  = new ArrayList<Integer>();
        result = authDBOperations.getNotApprovedStudent();
        return result;
    }

    @Override
    public Course addNewCourse(String description, String courseName, long fee) throws CRSException {

        logger.info("Adding new course");
        Course course = courseDB.addNewCourse(description,courseName,fee);
        return course;
    }
}

package com.flipkart.services;

import com.flipkart.exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;

import java.util.logging.Logger;


public class CourseRegistrationServices implements CourseRegistrationInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(CourseRegistrationServices.class));

    @Override
    public Boolean registerCourse(Student student, Course course) throws CourseRegistrationException {
        logger.info("Registering for the course");
        return CourseDB.registerStudent(student,course);
    }

    @Override
    public Boolean removeCourse(Student student, Course course) throws CourseRegistrationException {
        logger.info("Removing the course");
        return CourseDB.removeStudent(student,course);
    }

    @Override
    public Boolean addCourse(Student student, Course course) throws CourseRegistrationException {
        logger.info("Adding the course");
        return CourseDB.addStudent(student,course);
    }

    @Override
    public Boolean makePayment() {
        return null;
    }
}

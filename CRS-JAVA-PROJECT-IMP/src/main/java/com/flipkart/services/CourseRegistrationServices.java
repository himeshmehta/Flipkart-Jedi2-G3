package com.flipkart.services;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;

import java.util.List;
import java.util.logging.Logger;


public class CourseRegistrationServices implements CourseRegistrationInterface{
    private CourseDB courseDBOperations;

    public CourseRegistrationServices(){
        this.courseDBOperations = new CourseDB();
    }

    private static final Logger logger = Logger.getLogger(String.valueOf(CourseRegistrationServices.class));

    @Override
    public Boolean registerCourse(Student student, Integer courseId) throws CourseRegistrationException {
        logger.info("Registering for the course");
        return courseDBOperations.registerStudent(student,courseId);
        }

    @Override
    public Boolean removeCourse(Student student, Integer courseId) throws CourseRegistrationException{
        logger.info("Removing the course");
        return courseDBOperations.removeStudent(student,courseId);
        }

    @Override
    public List<Course> viewCourses(Student student) throws CourseRegistrationException{
        logger.info("Adding the course");
        return courseDBOperations.viewCourses(student);
        }

    @Override
    public Boolean makePayment() {
        logger.info("Taking to the Payment gateway");
        return null;
    }
}

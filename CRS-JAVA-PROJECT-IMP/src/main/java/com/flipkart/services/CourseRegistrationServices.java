package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;


public class CourseRegistrationServices implements CourseRegistrationInterface{
    private CourseDB courseDBOperations;

    public CourseRegistrationServices(){
        this.courseDBOperations = new CourseDB();
    }

    private static final Logger logger = Logger.getLogger(CourseRegistrationServices.class);

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
    public List<Course> viewCourses() throws CourseRegistrationException{
        logger.info("Viewing Courses");
        return courseDBOperations.viewCourses();
        }

    @Override
    public HashMap<Integer, Integer> getNotPaidCourseList(int studentId) throws CRSException {
        logger.info("Getting not paid registered courses");
        return courseDBOperations.getNotpaidCourseList(studentId);
    }

    @Override
    public void setPaidFee(int studentId, Set<Integer> selectedCourses) throws CRSException {
        logger.info("Setting isPaidFee to TRUE");
        courseDBOperations.setPaidFeeToTRUE(studentId, selectedCourses);
    }

}

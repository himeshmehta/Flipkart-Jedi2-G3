package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface CourseRegistrationInterface {

    /**
     *
     This method is used to register for the Course.
     @Param - student , course
     @Throws - CourseRegistrationException
     @returns - Boolean
     **/
    Boolean registerCourse(Student student, Integer courseId) throws CourseRegistrationException;

    /**
     *
     This method is used to remove the Course.
     @Param - student , course
     @Throws - CourseRegistrationException
     @returns - Boolean
     **/
    Boolean removeCourse(Student student, Integer courseId) throws CourseRegistrationException;

    /**
     *
     This method is used to add the the Course.
     @Param - student , course
     @Throws - CourseRegistrationException
     @returns - Boolean
     **/
    List<Course> viewCourses() throws CourseRegistrationException;

    public HashMap<Integer,Integer> getNotPaidCourseList(int studentId) throws CRSException;

    public void setPaidFee(int studentId, Set<Integer> selectedCourses) throws CRSException;
}

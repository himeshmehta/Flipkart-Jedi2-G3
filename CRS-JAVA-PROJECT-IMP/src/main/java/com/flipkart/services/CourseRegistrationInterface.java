package com.flipkart.services;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

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

    /**
     *
     This method is used to make the payment for the Course.
     @Param - None
     @Throws - Nothing
     @returns - Boolean
     **/
    Boolean makePayment();

}

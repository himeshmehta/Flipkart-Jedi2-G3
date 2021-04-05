package com.flipkart.services;

import com.flipkart.exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface CourseRegistrationInterface {

    /**
     *
     This method is used to authenticate the User from the Database.
     @Param - userId , password
     @Throws - AuthorizationException
     @returns - User

     **/
    Boolean registerCourse(Student student, Course course) throws CourseRegistrationException;

    Boolean removeCourse(Student student, Course course) throws CourseRegistrationException;

    Boolean addCourse(Student student, Course course) throws CourseRegistrationException;

    Boolean makePayment();

}

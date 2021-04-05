package com.flipkart.services;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface CourseRegistrationInterface {

    Boolean registerCourse(Student student, Course course) throws CourseRegistrationException;

    Boolean removeCourse(Student student, Course course) throws CourseRegistrationException;

    Boolean addCourse(Student student, Course course) throws CourseRegistrationException;

    Boolean makePayment();

}

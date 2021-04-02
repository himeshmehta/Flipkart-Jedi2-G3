package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface CourseRegistrationInterface {

    Boolean registerCourse(Student student, Course course);

    Boolean removeCourse(Student student, Course course);

    Boolean addCourse(Student student, Course course);

    Boolean makePayment();

}

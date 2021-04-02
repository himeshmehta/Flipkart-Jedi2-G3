package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;


public class CourseRegistrationServices implements CourseRegistrationInterface{

    @Override
    public Boolean registerCourse(Student student, Course course) {
        return CourseDB.registerStudent(student,course);
    }

    @Override
    public Boolean removeCourse(Student student, Course course) {
        return CourseDB.removeStudent(student,course);
    }

    @Override
    public Boolean addCourse(Student student, Course course) {
        return CourseDB.addStudent(student,course);
    }

    @Override
    public Boolean makePayment() {
        return null;
    }
}

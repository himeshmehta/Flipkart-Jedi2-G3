package com.flipkart.services;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;


public class CourseRegistrationServices implements CourseRegistrationInterface{
    private CourseDB courseDBOperations;

    public CourseRegistrationServices(){
        this.courseDBOperations = new CourseDB();
    }

    @Override
    public Boolean registerCourse(Student student, Course course) throws CourseRegistrationException {
        return courseDBOperations.registerStudent(student,course);
    }

    @Override
    public Boolean removeCourse(Student student, Course course) throws CourseRegistrationException {
        return courseDBOperations.removeStudent(student,course);
    }

    @Override
    public Boolean addCourse(Student student, Course course) throws CourseRegistrationException {
        return courseDBOperations.addStudent(student,course);
    }

    @Override
    public Boolean makePayment() {
        return null;
    }
}

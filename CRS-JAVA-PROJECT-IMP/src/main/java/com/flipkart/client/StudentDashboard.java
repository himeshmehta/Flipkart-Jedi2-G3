package com.flipkart.client;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.Role;
import com.flipkart.dao.StudentDB;
import com.flipkart.services.CourseRegistrationServices;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class StudentDashboard {
    Student student;
    CourseRegistrationServices courseRegistrationServices;
    StudentDB studentDB;
    private static final Logger logger = Logger.getLogger(String.valueOf(StudentDashboard.class));

    public StudentDashboard(Student student) {
        this.student = student;
        courseRegistrationServices = new CourseRegistrationServices();
        this.studentDB = new StudentDB();
    }

    public Boolean registerCourse(Course course) {
        try {
            return courseRegistrationServices.registerCourse(student, course);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean addCourse(Course course) {
        try {
            return courseRegistrationServices.addCourse(student, course);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean removeCourse(Course course) {
        try {
            return courseRegistrationServices.removeCourse(student, course);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public List<Course> getRegisteredCourses() {
        return studentDB.registeredCourses(student);
    }



}
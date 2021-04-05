package com.flipkart.client;

import com.flipkart.exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDB;
import com.flipkart.services.CourseRegistrationServices;

import java.util.List;

public class StudentDashboard {
    Student student;
    CourseRegistrationServices courseRegistrationServices;

    public StudentDashboard(Student student) {
        this.student = student;
        courseRegistrationServices = new CourseRegistrationServices();
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
        return StudentDB.registeredCourses(student);
    }
}

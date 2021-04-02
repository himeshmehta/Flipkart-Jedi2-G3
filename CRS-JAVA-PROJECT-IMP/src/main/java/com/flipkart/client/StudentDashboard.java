package com.flipkart.client;

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
        return courseRegistrationServices.registerCourse(student,course);
    }

    public Boolean addCourse(Course course) {
        return courseRegistrationServices.addCourse(student,course);
    }

    public Boolean removeCourse(Course course) {
        return courseRegistrationServices.removeCourse(student,course);
    }

    public List<Course> getRegisteredCourses() {
        return StudentDB.registeredCourses(student);
    }
}

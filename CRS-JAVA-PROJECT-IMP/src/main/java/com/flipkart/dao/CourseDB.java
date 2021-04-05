package com.flipkart.dao;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static Boolean registerStudent(Student student , Course course) throws CourseRegistrationException {
        return Boolean.TRUE;
    }

    public static Boolean removeStudent (Student student , Course course) throws CourseRegistrationException {
        return Boolean.TRUE;
    }

    public static Boolean addStudent (Student student , Course course) throws CourseRegistrationException {
        return Boolean.TRUE;
    }

    public static List<Student> getListOfRegisteredStudents (Course course) {
        return new ArrayList<>();
    }

    public static Boolean setProfessor(Course course , Professor professor) {
        return Boolean.TRUE;
    }

    public static Boolean setAvailability(Course course) {
        return Boolean.TRUE;
    }

    public static Course getCourseDetails(String courseID){
        return null;
    }
}
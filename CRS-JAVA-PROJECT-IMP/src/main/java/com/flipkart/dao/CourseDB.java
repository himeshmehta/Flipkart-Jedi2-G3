package com.flipkart.dao;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseDB implements CourseDBInterface{
    public  Boolean registerStudent(Student student , Course course) throws CourseRegistrationException {
        throw new CourseRegistrationException("Unable to register");
    }

    public  Boolean removeStudent (Student student , Course course){
        return Boolean.TRUE;
    }

    public  Boolean addStudent (Student student , Course course){
        return Boolean.TRUE;
    }

    public  List<Student> getListOfRegisteredStudents (Course course) {
        return new ArrayList<>();
    }

    public  Boolean setProfessor(Course course , Professor professor) {
        return Boolean.TRUE;
    }

    public  Boolean setAvailability(Course course) {
        return Boolean.TRUE;
    }

    public  Course getCourseDetails(String courseID){
        return null;
    }

    public List<Student> getListOfStudents(String courseId) {
        List<Student> studentList = new ArrayList<Student>();

        return studentList;
    }
}
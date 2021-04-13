package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {

    /**
     *
     This method returns all the course.
     @param - Nothing
     @throws - Nothing
     @return - List of Courses
     **/
    public List<Course> viewCourses();

    /**
     *
     This method returns all the enrolled course for the Professor.
     @param - professor
     @throws - Nothing
     @return - List of Courses
     **/
    public List<Course> viewEnrolledCourses(int professor) throws CRSException;

    /**
     *
     This method selects the course which will be taught by the Professor.
     @param - courseId , professor
     @throws - CRSException
     @return - Boolean
     **/
    public Boolean selectCourseToTeach(Integer courseId, Professor professor) throws CRSException;


    /**
     *
     This method returns the list of enrolled Students.
     @param - courseId
     @throws - Nothing
     @return - List of Students
     **/
    public List<Student> getEnrolledStudents(Integer courseId) throws CRSException;


}

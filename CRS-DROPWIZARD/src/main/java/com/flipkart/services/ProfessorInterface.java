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
     @Param - Nothing
     @Throws - Nothing
     @returns - List of Courses
     **/
    public List<Course> viewCourses();

    /**
     *
     This method returns all the enrolled course for the Professor.
     @Param - professor
     @Throws - Nothing
     @returns - List of Courses
     **/
    public List<Course> viewEnrolledCourses(int professor);

    /**
     *
     This method selects the course which will be taught by the Professor.
     @Param - courseId , professor
     @Throws - CRSException
     @returns - Boolean
     **/
    public Boolean selectCourseToTeach(Integer courseId, Professor professor) throws CRSException;


    /**
     *
     This method returns the list of enrolled Students.
     @Param - courseId
     @Throws - Nothing
     @returns - List of Students
     **/
    public List<Student> getEnrolledStudents(Integer courseId);


}

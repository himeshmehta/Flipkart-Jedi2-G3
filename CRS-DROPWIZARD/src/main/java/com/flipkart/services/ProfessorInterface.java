package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {

    /**
     *
     This method selects the course which will be taught by the Professor.
     @Param - Nothing
     @Throws - Nothing
     @returns - List of Courses
     **/
    public List<Course> viewCourses();

    /**
     *
     This method selects the course which will be taught by the Professor.
     @Param - professor
     @Throws - Nothing
     @returns - List of Courses
     **/
    public List<Course> viewEnrolledCourses(int professor);

    /**
     *
     This method selects the course which will be taught by the Professor.
     @Param - courseId
     @Throws - Nothing
     @returns - Course
     **/
    public Boolean selectCourseToTeach(Integer courseId, Professor professor) throws CRSException;

    /**
     *
     This method adds the grade for the student.
     @Param - courseId,marks,studentId
     @Throws - Nothing
     @returns - Nothing
     **/
    public void addGrades(Integer courseId, long marks, Integer studentId);

    /**
     *
     This method returns the list of enrolled Students.
     @Param - courseId
     @Throws - Nothing
     @returns - List of Students
     **/
    public List<Student> getEnrolledStudents(Integer courseId);


}

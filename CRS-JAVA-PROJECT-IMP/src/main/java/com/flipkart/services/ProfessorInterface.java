package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {

    /**
     *
     This method selects the course which will be taught by the Professor.
     @Param - courseId
     @Throws - Nothing
     @returns - Course
     **/
    public Course selectCourseToTeach(Integer courseId);

    /**
     *
     This method adds the grade for the student.
     @Param - courseId,marks,studentId
     @Throws - Nothing
     @returns - Nothing
     **/
    public void addGrades(Integer courseId,long marks,Integer studentId);

    /**
     *
     This method returns the list of enrolled Students.
     @Param - courseId
     @Throws - Nothing
     @returns - List of Students
     **/
    public List<Student> getEnrolledStudents(Integer courseId);


}

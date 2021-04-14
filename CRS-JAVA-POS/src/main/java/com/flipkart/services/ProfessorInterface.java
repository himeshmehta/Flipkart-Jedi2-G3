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
     **/
    public List<Course> viewCourses();

    /**
     * This method returns all the enrolled course for the Professor.
     * @param professor professor id
     * @throws CRSException
     */
    public List<Course> viewEnrolledCourses(int professor) throws CRSException;

    /**
     * This method selects the course which will be taught by the Professor.
     * @param courseId course id
     * @param professor professor object
     * @throws CRSException crs exception
     */
    public Boolean selectCourseToTeach(Integer courseId, Professor professor) throws CRSException;


    /**
     * This method returns the list of enrolled Students.
     * @param courseId course id
     * @throws CRSException crs exception
     */
    public List<Student> getEnrolledStudents(Integer courseId) throws CRSException;


}

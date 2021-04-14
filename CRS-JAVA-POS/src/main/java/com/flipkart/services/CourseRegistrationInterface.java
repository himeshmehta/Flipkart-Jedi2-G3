package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface CourseRegistrationInterface {

    /**
     * This method is used to register for the Course.
     * @param student student object
     * @param courseId course id
     * @throws CourseRegistrationException course registration exception
     * @return  boolean
     */
    Boolean registerCourse(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used to remove the Course.
     * @param student student object
     * @param courseId course id
     * @throws CourseRegistrationException course registration exception
     * @return boolean
     */
    Boolean removeCourse(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used to get the list of courses
     * @throws CourseRegistrationException course registration exception
     * @return  list
     */
    List<Course> viewCourses() throws CourseRegistrationException;

    /**
     * This method is used to get the list of not paid courses
     * @param studentId student id
     * @throws CRSException crs exception
     * @return map
     */

    public HashMap<Integer,Integer> getNotPaidCourseList(int studentId) throws CRSException;

    /**
     * This method is used to update the fee payment of courses selected by student
     * @param studentId student id
     * @param selectedCourses selected course
     * @throws CRSException crs exception
     */
    public void setPaidFee(int studentId, Set<Integer> selectedCourses) throws CRSException;
}

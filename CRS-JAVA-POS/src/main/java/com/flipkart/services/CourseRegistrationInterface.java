package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface CourseRegistrationInterface {

    /**
     *
     This method is used to register for the Course.
     @Param - student , course
     @Throws - CourseRegistrationException
     @returns - Boolean
     **/
    Boolean registerCourse(User student, Integer courseId) throws CourseRegistrationException;

    /**
     *
     This method is used to remove the Course.
     @Param - student , course
     @Throws - CourseRegistrationException
     @returns - Boolean
     **/
    Boolean removeCourse(User student, Integer courseId) throws CourseRegistrationException;

    /**
     *
     This method is used to add the the Course.
     @Param - student , course
     @Throws - CourseRegistrationException
     @returns - Boolean
     **/
    List<Course> viewCourses() throws CourseRegistrationException;

    /**
     * This method is used to get the list of not paid courses
     * @param studentId
     * @return hashMap of courseId and fee
     * @throws CRSException
     */

    public HashMap<Integer,Integer> getNotPaidCourseList(int studentId) throws CRSException;

    /**
     * This method is used to update the fee payment of courses selected by student
     * @param studentId
     * @param selectedCourses
     * @throws CRSException
     */
    public void setPaidFee(int studentId, Set<Integer> selectedCourses) throws CRSException;
}

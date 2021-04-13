package com.flipkart.helper;

import com.flipkart.Exception.CourseAlreadyExistException;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseDB;

/**
 * The type admin validator
 */
public class AdminValidator {
    private static CourseDB courseDB = new CourseDB();

    /**
     * This method is used to validate if course is already added or not
     * @param courseId
     * @throws CourseAlreadyExistException
     */
    public static void AdminCourseValidator(Integer courseId) throws CourseAlreadyExistException{
        Course course = courseDB.getCourseDetails(courseId);
        if (course != null) {
            throw new CourseAlreadyExistException("Course Already Added");
        }
    }
}

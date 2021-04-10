package com.flipkart.helper;

import com.flipkart.Exception.CourseAlreadyExistException;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseDB;

public class AdminValidator {
    private static CourseDB courseDB = new CourseDB();
    public static void AdminCourseValidator(Integer courseId) throws CourseAlreadyExistException{
        Course course = courseDB.getCourseDetails(courseId);
        if (course != null) {
            throw new CourseAlreadyExistException("Course Already Added");
        }
    }
}

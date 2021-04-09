package com.flipkart.helper;

import com.flipkart.Exception.InvalidCourseSelectionException;
import com.flipkart.bean.Course;
import com.flipkart.bean.CourseCatalog;

import java.util.List;

public class StudentValidator {

    private static CourseCatalog courseCatalog = new CourseCatalog();
    public static void studentCourseValidator(String studentId,int courseId) throws InvalidCourseSelectionException{
        List<Course> availableCourses = courseCatalog.getAvailableCourses();
        boolean isAvailable = false;
        for (Course course : availableCourses) {
            if (course.getCourseId()==courseId) {
                isAvailable = true;
                break;
            }
        }
        if (!isAvailable)
            throw new InvalidCourseSelectionException("Course not Available");
    }
}

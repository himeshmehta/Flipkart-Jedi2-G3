package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogDBInterface {
    /**
     * This method is used by admin to add new course in course catalog.
     * @param course :- Course object.
     * @return Boolean
     */
    public  Boolean updateCourseCatalog(Course course);

    /**
     * This method is used by all users to view courses available in course catalog.
     * @return List<Course> : list of course objects
     */
    public  List<Course> viewCourses();
}

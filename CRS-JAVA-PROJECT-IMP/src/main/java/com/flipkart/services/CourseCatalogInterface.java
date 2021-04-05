package com.flipkart.services;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {

    /**
     *
     This method is used to update the CourseCatalog Database.
     @Param - Course
     @Throws - Nothing
     @returns - Boolean

     **/
    public Boolean updateCourseList(Course newCourse);

    /**
     *
     This method is used to authenticate the User from the Database.
     @Param - None
     @Throws - Nothing
     @returns - List of Courses from CourseCatalog

     **/
    public List<Course> viewCourseList();
}

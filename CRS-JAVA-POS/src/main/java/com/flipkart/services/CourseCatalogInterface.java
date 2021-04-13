package com.flipkart.services;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {

    /**
     *
     This method is used to update the CourseCatalog Database.
     @param newCourse course object
     @return boolean

     **/
    public Boolean updateCourseList(Course newCourse);

    /**
     *
     This method is used to get the List of Courses.
     @return boolean
     **/
    public List<Course> viewCourseList();
}

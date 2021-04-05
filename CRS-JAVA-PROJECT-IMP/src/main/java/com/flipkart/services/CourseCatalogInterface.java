package com.flipkart.services;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseCatalogInterface {
    public Boolean updateCourseList(Course newCourse);

    public List<Course> viewCourseList();
}

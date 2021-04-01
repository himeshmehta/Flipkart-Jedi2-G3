package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalog;

public class CourseCatalogServices implements CourseCatalogInterface{
    @Override
    public Boolean updateCourseList(Course newCourse) {
        Boolean result = CourseCatalog.updateCourseCatalog(newCourse);
        return result;
    }
}

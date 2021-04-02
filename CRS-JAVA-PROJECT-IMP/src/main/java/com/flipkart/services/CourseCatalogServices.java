package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDB;

public class CourseCatalogServices implements CourseCatalogInterface{
    @Override
    public Boolean updateCourseList(Course newCourse) {
        Boolean result = CourseCatalogDB.updateCourseCatalog(newCourse);
        return result;
    }
}

package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CourseCatalogServices implements CourseCatalogInterface{
    private static final Logger logger = Logger.getLogger(String.valueOf(CourseCatalogServices.class));

    @Override
    public Boolean updateCourseList(Course newCourse) {
        Boolean result = CourseCatalogDB.updateCourseCatalog(newCourse);
        logger.info("Updating Course List");
        return result;
    }

    public List<Course> viewCourseList()
    {
        List<Course> courseList=new ArrayList<>();
        logger.info("Fetching Course List");
        return courseList;

    }

}

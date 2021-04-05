package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalog;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalogServices implements CourseCatalogInterface{
    @Override
    public Boolean updateCourseList(Course newCourse) {
        Boolean result = CourseCatalog.updateCourseCatalog(newCourse);
        return result;
    }

    public List<Course> viewCourseList()
    {
        List<Course> courseList=new ArrayList<Course>();



        return courseList;

    }

}

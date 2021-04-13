package com.flipkart.src.main.java.com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDBInterface;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalogDB implements CourseCatalogDBInterface {

    public  Boolean updateCourseCatalog(Course course) {
        return Boolean.TRUE;
    }

    public List<Course> viewCourses() {
        return new ArrayList<>();
    }
}

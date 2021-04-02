package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalogDB {

    public static Boolean updateCourseCatalog(Course course) {
        return Boolean.TRUE;
    }

    public static List<Course> viewCourses() {
        return new ArrayList<>();
    }
}

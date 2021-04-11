package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.dao.CourseCatalogDB;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CourseCatalogServices implements CourseCatalogInterface{

    private CourseCatalogDB catalogOperations;

    public CourseCatalogServices(){
        this.catalogOperations = new CourseCatalogDB();
    }

    private static final Logger logger = Logger.getLogger(CourseCatalogServices.class);

    @Override
    public Boolean updateCourseList(Course newCourse) {
        logger.info("Updating Course List");
        Boolean result = catalogOperations.updateCourseCatalog(newCourse);
        return result;
    }

    public List<Course> viewCourseList()
    {
        List<Course> courseList=new ArrayList<>();
        logger.info("Fetching Course List");
        return courseList;

    }

}

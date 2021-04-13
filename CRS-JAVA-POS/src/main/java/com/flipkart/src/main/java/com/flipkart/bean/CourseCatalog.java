package com.flipkart.src.main.java.com.flipkart.bean;
import com.flipkart.bean.Course;

import java.util.*;

/**
 * The type course catalog
 */
public class CourseCatalog {

    private List<com.flipkart.bean.Course> availableCourses;

    /**
     * Gets the list of available courses
     * @return
     */
    public List<com.flipkart.bean.Course> getAvailableCourses() {
        return availableCourses;
    }

    /**
     * Sets the list of available courses
     * @param availableCourses
     */
    public void setAvailableCourses(List<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
}

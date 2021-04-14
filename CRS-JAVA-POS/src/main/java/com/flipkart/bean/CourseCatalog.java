package com.flipkart.bean;

import java.util.List;

/**
 * The type course catalog
 */
public class CourseCatalog {

    private List<Course> availableCourses;

    /**
     * Gets the list of available courses
     * @return List of Courses
     */
    public List<Course> getAvailableCourses() {
        return availableCourses;
    }

    /**
     * Sets the list of available courses
     * @param availableCourses available courses
     */
    public void setAvailableCourses(List<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
}

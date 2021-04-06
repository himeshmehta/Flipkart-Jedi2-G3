package com.flipkart.bean;
import java.util.*;

/**
 * The type course catalog
 */
public class CourseCatalog {

    private List<Course> availableCourses;

    /**
     * Gets the list of available courses
     * @return
     */
    public List<Course> getAvailableCourses() {
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

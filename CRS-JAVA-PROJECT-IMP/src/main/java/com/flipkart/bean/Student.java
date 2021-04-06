package com.flipkart.bean;

import com.flipkart.constants.Role;

import java.util.*;

/**
 * The type student
 */
public class Student extends User{

    private String id;
    private List<Course>mainCourseList;
    private List<String>alternateCourseList;

    public Student(String name, String email, Role role) {
        super(name, email, role);
    }

    /**
     * Gets the student id
     * @return the student id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the student id
     * @param id the student id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the main course List
     * @return main course List
     */
    public List<Course> getMainCourseList() {
        return mainCourseList;
    }

    /**
     * Sets the main course List
     * @param mainCourseList
     */
    public void setMainCourseList(List<Course> mainCourseList) {
        this.mainCourseList = mainCourseList;
    }

    /**
     * Gets the alternate course List
     * @return the alternate course List
     */
    public List<String> getAlternateCourseList() {
        return alternateCourseList;
    }

    /**
     * Sets the alternate course List
     * @param alternateCourseList
     */
    public void setAlternateCourseList(List<String> alternateCourseList) {
        this.alternateCourseList = alternateCourseList;
    }
}
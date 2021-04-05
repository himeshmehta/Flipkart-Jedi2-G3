package com.flipkart.bean;

import com.flipkart.constants.Role;

import java.util.*;

public class Student extends User{

    private String id;
    private List<Course>mainCourseList;
    private List<String>alternateCourseList;

    public Student(String name, String email, Role role) {
        super(name, email, role);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getMainCourseList() {
        return mainCourseList;
    }

    public void setMainCourseList(List<Course> mainCourseList) {
        this.mainCourseList = mainCourseList;
    }

    public List<String> getAlternateCourseList() {
        return alternateCourseList;
    }

    public void setAlternateCourseList(List<String> alternateCourseList) {
        this.alternateCourseList = alternateCourseList;
    }
}
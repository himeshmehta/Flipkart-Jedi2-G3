package com.flipkart.bean;

import java.util.*;

public class Student {

        private String id;
        private List<Course>mainCourseList;
        private List<String>alternateCourseList;

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

package com.flipkart.bean;

import java.util.List;

public class Professor {

    private List<Course> teachingCourses;

    public List<Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(List<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }
}

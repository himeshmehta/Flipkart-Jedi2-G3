package com.flipkart.bean;

import java.util.List;

public class Professor {

       private String id;
       private List<Course> teachingCourses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(List<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }
}

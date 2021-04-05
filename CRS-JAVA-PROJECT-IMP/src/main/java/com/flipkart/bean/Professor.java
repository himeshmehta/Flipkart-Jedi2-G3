package com.flipkart.bean;

import com.flipkart.constants.Role;

import java.util.List;

public class Professor extends User{

    private List<Course> teachingCourses;

    public Professor(String name, String email, Role role) {
        super(name, email, role);
    }

    public List<Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(List<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }
}

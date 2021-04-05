package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDB implements StudentDBInterface{
    public List<Course> registeredCourses(Student student) {
        return new ArrayList<>();
    }
}

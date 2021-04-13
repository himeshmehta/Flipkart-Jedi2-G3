package com.flipkart.src.main.java.com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface StudentDBInterface {
    /**
     * This method is used to get list of course registered by student.
     * @Param student :- Student Object.
     * @Throws Nothing
     * @return List<Course> :- list of course registered by student.
     */
    public List<Course> registeredCourses(Student student);
}

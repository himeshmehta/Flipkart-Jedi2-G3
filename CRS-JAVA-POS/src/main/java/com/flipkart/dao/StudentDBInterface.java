package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface StudentDBInterface {
    /**
     * This method is used to get list of course registered by student.
     * @param student :- Student Object.
     * @return list
     */
    public List<Course> registeredCourses(Student student);
}

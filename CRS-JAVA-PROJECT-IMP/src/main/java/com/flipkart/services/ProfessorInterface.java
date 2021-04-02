package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {

    public Course selectCourseToTeach(String courseId);

    public void addGrades(String courseId,long marks,String studentId);

    public List<Student> getEnrolledStudents(String courseId);


}

package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.services.ProfessorServices;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDashboard {

    private User professor;
    private ProfessorServices professorServices;

    public ProfessorDashboard(User professor)
    {
        this.professor=professor;
    }

    public Course selectCourseToTeach(String courseId)
    {

        Course course=professorServices.selectCourseToTeach(courseId);

        return course;
    }


    public List<Student> getEnrolledStudents(String courseId)
    {
        List<Student> studentList=professorServices.getEnrolledStudents(courseId);



        return studentList;
    }

    public void addGrades(String courseId,long marks,String studentId)
    {
       professorServices.addGrades(courseId,marks,studentId);
    }
}

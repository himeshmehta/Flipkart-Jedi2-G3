package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.ProfessorServices;

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
       try {
           GradeCardServices gradeCardServices = new GradeCardServices();
           // add grades
           gradeCardServices.addGrade(,);
       } catch (Exception ex){

       }
    }
}

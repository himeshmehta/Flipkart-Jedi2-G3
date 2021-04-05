package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.ProfessorServices;

import java.util.List;

public class ProfessorDashboard {

    private Professor professor;
    private ProfessorServices professorServices;

    public ProfessorDashboard(Professor professor)
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

    public void addGrades(String courseId,Integer marks,String studentId)
    {
       try {
           GradeCardServices gradeCardServices = new GradeCardServices();
           // add grades
           gradeCardServices.addGrade(professor.getUserId(),courseId,marks,studentId);
       } catch (Exception ex){

       }
    }
}

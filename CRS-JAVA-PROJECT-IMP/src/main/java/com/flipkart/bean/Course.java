package com.flipkart.bean;
import java.util.*;
public class Course {

   private  String CourseName;
   private String CourseId;
   private String ProfessorId ;
   private Boolean IsAvailable;
   private List<Student> StudentList ;

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public String getProfessorId() {
        return ProfessorId;
    }

    public void setProfessorId(String professorId) {
        ProfessorId = professorId;
    }

    public Boolean getAvailable() {
        return IsAvailable;
    }

    public void setAvailable(Boolean available) {
        IsAvailable = available;
    }

    public List<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(List<Student> studentList) {
        StudentList = studentList;
    }
}

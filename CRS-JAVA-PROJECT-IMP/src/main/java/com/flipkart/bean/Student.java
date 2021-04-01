package com.flipkart.bean;

import java.util.*;

public class Student {

        private String courseName;
        private String courseId;
        private String professorId;
    private Boolean isAvailable;
    private List<Student> studentList;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;


    }

    public String getProfessorId() {
        return professorId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}

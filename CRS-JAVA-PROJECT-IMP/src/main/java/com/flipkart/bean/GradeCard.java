package com.flipkart.bean;
import java.util.*;
public class GradeCard {

    private Student studentDetails;
    private Map<String,Integer>courseMarks;

    public Student getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(Student studentDetails) {
        this.studentDetails = studentDetails;
    }

    public Map<String, Integer> getCourseMarks() {
        return courseMarks;
    }

    public void setCourseMarks(Map<String, Integer> courseMarks) {
        this.courseMarks = courseMarks;
    }
}

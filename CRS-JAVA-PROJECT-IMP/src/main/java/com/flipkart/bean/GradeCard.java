package com.flipkart.bean;
import java.util.*;

/**
 * The type grade card
 */
public class GradeCard {

    private Student studentDetails;
    private Map<String,Integer>courseMarks;

    /**
     * Gets the student details
     * @return
     */
    public Student getStudentDetails() {
        return studentDetails;
    }

    /**
     * Sets the student details
     * @param studentDetails
     */
    public void setStudentDetails(Student studentDetails) {
        this.studentDetails = studentDetails;
    }

    /**
     * Gets the list of mark for respective courses
     * @return
     */
    public Map<String, Integer> getCourseMarks() {
        return courseMarks;
    }

    /**
     * Sets the list of marks for courses
     * @param courseMarks
     */
    public void setCourseMarks(Map<String, Integer> courseMarks) {
        this.courseMarks = courseMarks;
    }
}

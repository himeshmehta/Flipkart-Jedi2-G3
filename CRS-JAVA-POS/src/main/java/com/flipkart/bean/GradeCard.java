package com.flipkart.bean;

import java.util.Map;

/**
 * The type grade card
 */
public class GradeCard {

    private Student studentDetails;
    private Map<Integer,Integer>courseMarks;

    /**
     * Constructor of gradeCard
     * @param courseMarks course marks
     */
    public GradeCard(Map<Integer,Integer> courseMarks){
        this.courseMarks = courseMarks;
        this.studentDetails = new Student();
    }
    /**
     * Gets the student details
     * @return Student
     */
    public Student getStudentDetails() {
        return studentDetails;
    }

    /**
     * Sets the student details
     * @param studentDetails student details
     */
    public void setStudentDetails(Student studentDetails) {
        this.studentDetails = studentDetails;
    }

    /**
     * Gets the list of mark for respective courses
     * @return Map
     */
    public Map<Integer, Integer> getCourseMarks() {
        return courseMarks;
    }

    /**
     * Sets the list of marks for courses
     * @param courseMarks course marks
     */
    public void setCourseMarks(Map<Integer, Integer> courseMarks) {
        this.courseMarks = courseMarks;
    }
}

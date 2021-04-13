package com.flipkart.bean;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * The type grade card
 */
public class GradeCard {

    @NotNull
    private Student studentDetails;
    private Map<Integer,Integer>courseMarks;

    /**
     * Constructor of gradeCard
     * @param courseMarks
     */
    public GradeCard(Map<Integer,Integer> courseMarks){
        this.courseMarks = courseMarks;
        this.studentDetails = new Student();
    }
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
    public Map<Integer, Integer> getCourseMarks() {
        return courseMarks;
    }

    /**
     * Sets the list of marks for courses
     * @param courseMarks
     */
    public void setCourseMarks(Map<Integer, Integer> courseMarks) {
        this.courseMarks = courseMarks;
    }
}

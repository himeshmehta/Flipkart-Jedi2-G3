package com.flipkart.src.main.java.com.flipkart.bean;
import com.flipkart.bean.Student;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * The type grade card
 */
public class GradeCard {

    @NotNull
    private com.flipkart.bean.Student studentDetails;
    private Map<Integer,Integer>courseMarks;

    /**
     * Constructor of gradeCard
     * @param courseMarks
     */
    public GradeCard(Map<Integer,Integer> courseMarks){
        this.courseMarks = courseMarks;
        this.studentDetails = new com.flipkart.bean.Student();
    }
    /**
     * Gets the student details
     * @return
     */
    public com.flipkart.bean.Student getStudentDetails() {
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

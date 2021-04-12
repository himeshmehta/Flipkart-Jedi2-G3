package com.flipkart.bean;
// import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * The type course
 */
public class Course {

    private String CourseName;
    private int CourseId;
    private int ProfessorId;
    private Long fee;

    /**
     * Gets the fee
     *
     * @return
     */
    public Long getFee() {
        return fee;
    }

    /**
     * Sets the fee
     *
     * @param fee
     */
    public void setFee(Long fee) {
        this.fee = fee;
    }

    /**
     * Gets the course name
     *
     * @return
     */
    public String getCourseName() {
        return CourseName;
    }

    /**
     * Sets the course name
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    /**
     * Gets the course id
     *
     * @return
     */
    public int getCourseId() {
        return CourseId;
    }

    /**
     * Sets the course id
     *
     * @param courseId
     */
    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    /**
     * Gets the professor id
     *
     * @return
     */
    public int getProfessorId() {
        return ProfessorId;
    }

    /**
     * Sets the professor id
     *
     * @param professorId
     */
    public void setProfessorId(int professorId) {
        ProfessorId = professorId;
    }

}

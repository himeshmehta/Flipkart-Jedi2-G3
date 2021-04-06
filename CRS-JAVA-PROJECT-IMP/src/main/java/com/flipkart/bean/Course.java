package com.flipkart.bean;
import java.util.*;

/**
 * The type course
 */
public class Course {

   private String CourseName;
   private String CourseId;
   private String ProfessorId ;
   private Boolean IsAvailable;
   private List<Student> StudentList ;
   private Long fee;

    /**
     * Gets the fee
     * @return
     */
    public Long getFee() {
        return fee;
    }

    /**
     * Sets the fee
     * @param fee
     */
    public void setFee(Long fee) {
        this.fee = fee;
    }

    /**
     * Gets the course name
     * @return
     */
    public String getCourseName() {
        return CourseName;
    }

    /**
     * Sets the course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    /**
     * Gets the course id
     * @return
     */
    public String getCourseId() {
        return CourseId;
    }

    /**
     * Sets the course id
     * @param courseId
     */
    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    /**
     * Gets the professor id
     * @return
     */
    public String getProfessorId() {
        return ProfessorId;
    }

    /**
     * Sets the professor id
     * @param professorId
     */
    public void setProfessorId(String professorId) {
        ProfessorId = professorId;
    }

    /**
     * Gets the course availability
     * @return
     */
    public Boolean getAvailable() {
        return IsAvailable;
    }

    /**
     * Sets the course availability
     * @param available
     */
    public void setAvailable(Boolean available) {
        IsAvailable = available;
    }

    /**
     * Gets the list of students
     * @return
     */
    public List<Student> getStudentList() {
        return StudentList;
    }

    /**
     * Sets the list of students
     * @param studentList
     */
    public void setStudentList(List<Student> studentList) {
        StudentList = studentList;
    }
}

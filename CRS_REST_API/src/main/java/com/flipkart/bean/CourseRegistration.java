package com.flipkart.bean;

/**
 * The type course registration
 */
public class CourseRegistration {

    private String courseId;
    private String studentId;

    /**
     * Gets the course id
     * @return
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets the course id
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the student id
     * @return
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student id
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

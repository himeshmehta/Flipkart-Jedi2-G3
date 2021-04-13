package com.flipkart.src.main.java.com.flipkart.requestPojo;

import com.flipkart.bean.User;

public class StudentCourseRequest {
    private int courseId;
    private User student;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }
}

package com.flipkart.requestPojo;

import com.flipkart.bean.Professor;

public class SelectCourseToTeachRequest {
    private int courseId;
    private Professor professor;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

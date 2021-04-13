package com.flipkart.services;

import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.GradeCard;

public interface GradeCardInterface {
    /**
     *
     This method returns the gradeCard for a particular student.
     @param - studentId student id
     @throws - GradeCardNotFoundException grade card not found
     **/
    public GradeCard viewGradeCard(Integer studentId) throws GradeCardNotFoundException;

    /**
     * This method is used to addGrade for a Course.
     * @param profId professor id
     * @param courseId course id
     * @param grade grade
     * @param studentId student id
     * @throws Exception exception
     */
    public void addGrade(Integer profId, Integer courseId, Integer grade, Integer studentId) throws Exception;
}

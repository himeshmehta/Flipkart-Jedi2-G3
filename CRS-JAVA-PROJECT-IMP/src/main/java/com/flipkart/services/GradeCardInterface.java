package com.flipkart.services;

import com.flipkart.bean.GradeCard;

public interface GradeCardInterface {
    /**
     *
     This method returns the gradeCard for a particular student.
     @Param - studentId
     @Throws - Nothing
     @returns - GradeCard
     **/
    public GradeCard viewGradeCard(Integer studentId);

    /**
     *
     This method is used to addGrade for a Course.
     @Param - professorId,courseId,grade,studentId
     @Throws - Nothing
     @returns - Boolean
     **/
    public void addGrade(Integer professorId,Integer courseId, Integer grade,Integer studentId) throws Exception;
}

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
    public GradeCard viewGradeCard(String studentId);

    /**
     *
     This method is used to addGrade for a Course.
     @Param - professorId,courseId,grade,studentId
     @Throws - Nothing
     @returns - Boolean
     **/
    public void addGrade(int professorId,String courseId, Integer grade,String studentId) throws Exception;
}

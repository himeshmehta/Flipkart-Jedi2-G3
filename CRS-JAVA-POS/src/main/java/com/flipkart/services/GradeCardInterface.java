package com.flipkart.services;

import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.GradeCard;

public interface GradeCardInterface {
    /**
     *
     This method returns the gradeCard for a particular student.
     @param - studentId
     @throws - GradeCardNotFoundException
     @return - GradeCard
     **/
    public GradeCard viewGradeCard(Integer studentId) throws GradeCardNotFoundException;

    /**
     *
     This method is used to addGrade for a Course.
     @param - professorId , courseId , grade , studentId
     @throws - Exception
     @return - Nothing
     **/
    public void addGrade(Integer profId, Integer courseId, Integer grade, Integer studentId) throws Exception;
}

package com.flipkart.services;

import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.GradeCard;

public interface GradeCardInterface {
    public GradeCard viewGradeCard(String studentId);

    public void addGrade(String professorId,String courseId, Integer grade,String studentId) throws Exception;
}

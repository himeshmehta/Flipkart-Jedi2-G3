package com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.GradeCard;

public interface GradeCardDBInterface {
    /**
     * This method is used by student to view grade card.
     * @param studentId :- id of student.
     * @throws GradeCardNotFoundException
     * @return GradeCard object
     */
    public  GradeCard viewGradeCard(Integer studentId) throws GradeCardNotFoundException;

    /**
     * This method is used by professor to add grade for a course in grade card of student.
     * @param courseId :- id of course for which professor wants to add grade.
     * @param grade :- grades
     * @param studentId :- id of student.
     * @throws CRSException
     */
    public  void addGrade(Integer courseId, Integer grade, Integer studentId) throws CRSException;
}

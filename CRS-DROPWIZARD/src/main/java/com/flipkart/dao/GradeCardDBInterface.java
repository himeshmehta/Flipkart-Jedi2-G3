package com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.GradeCard;

public interface GradeCardDBInterface {
    /**
     * This method is used by student to view grade card.
     * @Param studentId :- id of student.
     * @Throws Nothing
     * @return GradeCard object
     */
    public  GradeCard viewGradeCard(Integer studentId) throws GradeCardNotFoundException;

    /**
     * This method is used by professor to add grade for a course in grade card of student.
     * @Param courseId :- id of course for which professor wants to add grade.
     * @Param grade :- grades
     * @Param studentId :- id of student.
     * @Throws Nothing
     * @return Nothing
     */
    public  void addGrade(Integer courseId, Integer grade, Integer studentId) throws CRSException;
}

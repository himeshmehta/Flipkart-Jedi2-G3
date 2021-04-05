package com.flipkart.services;

import com.flipkart.Exception.InvalidDataException;
import com.flipkart.Exception.InvalidInputException;
import com.flipkart.bean.GradeCard;
import com.flipkart.dao.GradeCardDB;
import com.flipkart.helper.CourseValidator;

public class GradeCardServices implements GradeCardInterface{

    public GradeCardDB gradeCardDB;
    public GradeCardServices(){
        this.gradeCardDB = new GradeCardDB();
    }
    @Override
    public GradeCard viewGradeCard(String studentId) {
        GradeCard gradeCard = gradeCardDB.viewGradeCard(studentId);
        return gradeCard;
    }

    @Override
    public void addGrade(String professorId, String courseId, Integer grade,String studentId) throws Exception {
        /**
         * This method is used to add grades .
         * @Param professorId :- id of professor who want to add grades
         * @Param courseId :- id of course.
         * @Param grade :- It is an Int value which represent grade. 0 <= grade <= 100.
         * @Param studentId :- id of student.
         * @return Nothing
         */

        try {
            if (grade < 0 || grade > 100){
                String message = grade <0 ? "Grade can not be negative." : "Grade can not be more than 100.";
                throw new InvalidDataException(message);
            }
            // validate : can only add grade if courseId is being taught  by professor
            CourseValidator.studentAndProfValidation(courseId,professorId, studentId);
            gradeCardDB.addGrade(professorId,courseId,grade,studentId);
        } catch (InvalidInputException e) {
            throw new Exception(e.getMessage());
        }
    }


}

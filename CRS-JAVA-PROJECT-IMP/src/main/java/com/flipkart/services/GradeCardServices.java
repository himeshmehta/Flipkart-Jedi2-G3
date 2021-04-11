package com.flipkart.services;

import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.GradeCard;
import com.flipkart.dao.CourseDB;
import com.flipkart.dao.GradeCardDB;

import org.apache.log4j.Logger;

public class GradeCardServices implements GradeCardInterface{

    public GradeCardDB gradeCardDB;
    public CourseDB courseDB;
    public GradeCardServices(){
        this.courseDB = new CourseDB();
        this.gradeCardDB = new GradeCardDB();
    }
    private static final Logger logger = Logger.getLogger(GradeCardServices.class);
    @Override
    public GradeCard viewGradeCard(Integer studentId) throws GradeCardNotFoundException {
        GradeCard gradeCard = gradeCardDB.viewGradeCard(studentId);
        logger.info("Fetching GradeCard");
        return gradeCard;
    }

    @Override
    public void addGrade( Integer profId,Integer courseId, Integer grade,Integer studentId) throws Exception {

        logger.info("Adding Grades");
        if (grade < 0 || grade > 100){
            String message = grade <0 ? "Grade can not be negative." : "Grade can not be more than 100.";
            throw new InvalidDataException(message);
        }
        // validate that course is being teach by this student.
        Boolean isCourseAssignedToProf = courseDB.IsCourseTeachByProf(courseId,profId);
        if(isCourseAssignedToProf) gradeCardDB.addGrade(courseId,grade,studentId);

    }


}

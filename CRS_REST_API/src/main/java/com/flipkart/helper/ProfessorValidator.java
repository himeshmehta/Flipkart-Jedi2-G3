package com.flipkart.helper;

import com.flipkart.Exception.InvalidCourseSelectionException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.dao.CourseDB;

public class ProfessorValidator {

    private static CourseDB courseDB = new CourseDB();

    public static void professorCourseValidator(String professorId,Integer courseId) throws InvalidCourseSelectionException{
        Course course = courseDB.getCourseDetails(courseId);
        Integer courseProfessorId = course.getProfessorId();
        if (courseProfessorId!=null && !courseProfessorId.equals(professorId)) {
            throw new InvalidCourseSelectionException("Unauthorized Operation attempted");
        }
    }

}

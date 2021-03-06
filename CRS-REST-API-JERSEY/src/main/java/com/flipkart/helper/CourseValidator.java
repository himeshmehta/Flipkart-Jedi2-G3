package com.flipkart.helper;

import com.flipkart.Exception.InvalidInputException;
import com.flipkart.bean.Course;
import com.flipkart.dao.CourseDB;

/**
 * The type course validator
 */
public class CourseValidator {

    private static CourseDB courseDB = new CourseDB();

    /**
     * This method is used used to validate student and professor for course
     * @param courseId
     * @param professorId
     * @param studentId
     * @throws InvalidInputException
     */
    public static void studentAndProfValidation(Integer courseId,Integer professorId, Integer studentId) throws InvalidInputException {
        Course courseDetails = courseDB.getCourseDetails(courseId);

//        // Course should be teach by professor
//        if(!courseDetails.getAvailable()){
//            throw new InvalidInputException("Course " + courseId + " is not available.");
//        }
////        if(!professorId.equals(courseDetails.getProfessorId())){
////            throw new InvalidInputException("Professor "+ professorId + " is not eligible to add grade for course "+courseId  );
////        }
//
//        boolean isCourseRegisteredByStudent = false;
//        for(Student student:courseDetails.getStudentList()){
//            if(studentId.equals(student.getEmail())){
//                isCourseRegisteredByStudent = true;
//                break;
//            }
//        }
//
//        if(!isCourseRegisteredByStudent){
//            throw new InvalidInputException("Student " + studentId+" did not registered for course "+courseId);
//        }
    }
}

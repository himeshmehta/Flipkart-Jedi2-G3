package com.flipkart.services;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Professor service.
 */

public class ProfessorServices implements ProfessorInterface {

    private static final Logger logger = Logger.getLogger(String.valueOf(com.flipkart.services.ProfessorServices.class));
    private CourseDB courseDB;

    public ProfessorServices(CourseDB courseDB) {
        this.courseDB = courseDB;
    }

    @Override
    public List<Course> viewCourses() {
        return courseDB.viewCourses();

    }

    @Override
    public List<Course> viewEnrolledCourses(int professorId) throws CRSException{
        return courseDB.viewEnrolledCourses(professorId);
    }

    @Override
    public Boolean selectCourseToTeach(Integer courseId, Professor professor) throws CRSException {
        return courseDB.setProfessor(courseId, professor);
    }


    @Override
    public List<Student> getEnrolledStudents(Integer courseId) throws CRSException{
        List<Student> studentList = new ArrayList<Student>();

        logger.info("Fetching Enrolled Students List");
        studentList = courseDB.getListOfStudents(courseId);

        return studentList;
    }
}

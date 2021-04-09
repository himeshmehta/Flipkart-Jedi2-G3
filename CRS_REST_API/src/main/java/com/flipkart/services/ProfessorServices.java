package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Professor service.
 */

public class ProfessorServices implements ProfessorInterface{

      private static final Logger logger = Logger.getLogger(String.valueOf(ProfessorServices.class));
      private CourseDB courseDB;
      public ProfessorServices(CourseDB courseDB)
      {
            this.courseDB = courseDB;
      }

      public List<Course> viewCourses() {
          return courseDB.viewCourses();

      }

    public List<Course> viewEnrolledCourses(int professorId) {
        return courseDB.viewEnrolledCourses(professorId);

    }

    /**
     * Professor select the course he teach

     * @param courseId The course which is taught by professor
     */

      public  Boolean selectCourseToTeach(Integer courseId , Professor professor)
      {
          return courseDB.setProfessor(courseId,professor);
      }
    /**
     * To get the list of students in particular course
     *
     * @param courseId The course for list of students needed
     */

      public List<Student> getEnrolledStudents(Integer courseId)
      {
                 List<Student> studentList=new ArrayList<Student>();

                 logger.info("Fetching Enrolled Students List");
                 studentList=courseDB.getListOfStudents(courseId);

                 return studentList;
      }

    /**
     * Records student grades

     * @param studentId StudentID of the student whose grades need to be recorded
     * @param marks  being assigned to the student for the course
     * @param courseId The course for which the student is being graded
     */

    public void addGrades(Integer courseId,long marks,Integer studentId)
    {
              //todo
    }
}

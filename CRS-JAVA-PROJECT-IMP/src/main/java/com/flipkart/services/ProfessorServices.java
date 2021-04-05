package com.flipkart.services;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDao;


import java.util.ArrayList;
import java.util.List;
/**
 * The type Professor service.
 */

public class ProfessorServices implements ProfessorInterface{

      private CourseCatalogServices courseCatalogServices;
      private CourseDao courseDao;
      public ProfessorServices(CourseCatalogServices courseCatalogServices,CourseDao courseDao)
      {
            this.courseCatalogServices=courseCatalogServices;
            this.courseDao=courseDao;

      }

    /**
     * Professor select the course he teach

     * @param courseId The course which is taught by professor
     */

      public  Course selectCourseToTeach(String courseId)
      {
          List<Course> courseList=courseCatalogServices.viewCourseList();
          Course course=new Course();
          for(Course cs:courseList)
          {
              if(cs.getCourseId().equals(courseId))
              {
                  course=cs;
              }

          }
          return course;
      }
    /**
     * To get the list of students in particular course
     *
     * @param courseId The course for list of students needed
     */

      public List<Student> getEnrolledStudents(String courseId)
      {
                 List<Student> studentList=new ArrayList<Student>();

                 studentList=courseDao.getListOfStudents(courseId);

                 return studentList;
      }

    /**
     * Records student grades

     * @param studentId StudentID of the student whose grades need to be recorded
     * @param marks  being assigned to the student for the course
     * @param courseId The course for which the student is being graded
     */

    public void addGrades(String courseId,long marks,String studentId)
    {
              //todo
    }
}

package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.ProfessorServices;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


public class ProfessorDashboard {

    private Professor professor;
    private ProfessorServices professorServices;
    private static final Logger logger = Logger.getLogger(String.valueOf(ProfessorDashboard.class));

    public ProfessorDashboard(Professor professor)
    {
        this.professor=professor;
    }

    public Course selectCourseToTeach(String courseId)
    {

        Course course=professorServices.selectCourseToTeach(courseId);

        return course;
    }


    public List<Student> getEnrolledStudents(String courseId)
    {
        List<Student> studentList=professorServices.getEnrolledStudents(courseId);
        return studentList;
    }

    public void addGrades(String courseId,Integer marks,String studentId)
    {
       try {
           GradeCardServices gradeCardServices = new GradeCardServices();
           // add grades
           gradeCardServices.addGrade(professor.getUserId(),courseId,marks,studentId);
       } catch (Exception ex){

       }
    }

    public void helper()
    {

          Scanner inputReader = new Scanner(System.in);
          Boolean result;
            while (true) {
                logger.info("Select operation to perform");
                int operation = inputReader.nextInt();
                if (operation == -1) break;

                switch (operation) {
                    case 1:

                        String courseId = inputReader.next();


                        Course course=selectCourseToTeach(courseId);
                        result=course!=null?true:false;
                        String message = result ? "Course fetched successfully" : "No Course found";
                        logger.info(message);
                        break;

                    case 2:
                         courseId = inputReader.next();

                        List<Student> studentList=getEnrolledStudents(courseId);
                        result=studentList.isEmpty()?false:true;
                        message = result ? "List of Students fetched successfully" : "Something Wrong";
                        logger.info(message);
                        break;

                    case 3:

                        long marks=Long.parseLong(inputReader.next());
                        String studentId=inputReader.next();
                        courseId = inputReader.next();


                        addGrades(courseId,marks,studentId);

                        break;

                    default:
                        logger.info("No operations");
                        break;

                }
            }
        }
    }


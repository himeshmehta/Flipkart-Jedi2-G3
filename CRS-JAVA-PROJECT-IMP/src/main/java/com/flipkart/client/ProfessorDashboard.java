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

    public Course selectCourseToTeach(int courseId)
    {

        Course course=professorServices.selectCourseToTeach(courseId);

        return course;
    }


    public List<Student> getEnrolledStudents(int courseId)
    {
        List<Student> studentList=professorServices.getEnrolledStudents(courseId);
        return studentList;
    }

    public void addGrades(Integer courseId,Integer marks,Integer studentId)
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
            System.out.println("Select operation to perform");
            System.out.println("1. Select course to teach");
            System.out.println("2. View Enrolled Students");
            System.out.println("3. Add Grades");
            int operation = inputReader.nextInt();
            if (operation == -1) break;

            switch (operation) {
                case 1:
                    System.out.println("Enter Course ID");
                    int courseId = inputReader.nextInt();
                    Course course=selectCourseToTeach(courseId);
                    result=course!=null?true:false;
                    String message = result ? "Course fetched successfully" : "No Course found";
                    logger.info(message);
                    break;

                case 2:
                    System.out.println("Enter Course ID");
                    courseId = inputReader.nextInt();
                    List<Student> studentList=getEnrolledStudents(courseId);
                    result=studentList.isEmpty()?false:true;
                    message = result ? "List of Students fetched successfully" : "Something Wrong";
                    logger.info(message);
                    break;

                case 3:
                    System.out.println("Enter Marks");
                    int marks=inputReader.nextInt();
                    System.out.println("Enter Student ID");
                    int studentId=inputReader.nextInt();
                    courseId = inputReader.nextInt();
                    addGrades(courseId, (int) marks,studentId);
                    break;

                default:
                    logger.info("No operations");
                    break;

            }
        }
    }
}
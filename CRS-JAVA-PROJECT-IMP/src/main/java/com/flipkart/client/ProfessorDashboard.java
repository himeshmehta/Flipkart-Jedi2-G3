package com.flipkart.client;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;
import com.flipkart.services.CourseCatalogServices;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.ProfessorServices;

import java.util.ArrayList;
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
        professorServices = new ProfessorServices(new CourseCatalogServices(), new CourseDB());
    }

    public Boolean selectCourseToTeach(int courseId)
    {

        return professorServices.selectCourseToTeach(courseId , professor);

    }

    public List<Course> viewAllCourses() {
        try {
            return professorServices.viewCourses();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Course> viewSelectedCourses() {
        try {
            return professorServices.viewEnrolledCourses(professor);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
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
            System.out.println("4. View Selected Courses");
            System.out.println("5. View All Courses");
            int operation = inputReader.nextInt();
            if (operation == -1) break;

            switch (operation) {
                case 1:
                    System.out.println("Enter Course ID");
                    int courseId = inputReader.nextInt();
                    result=selectCourseToTeach(courseId);
                    String message = result ? "Course selected successfully" : "Either course not present or Course not available to select";
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
                case 4 :
                    List<Course> list = viewSelectedCourses();
                    System.out.println("Enrolled Courses : ");
                    System.out.println("ID Name Fee ProfID");
                    for (Course cs : list) {
                        message = cs.getCourseId() + "  " + cs.getCourseName() + "   " + cs.getFee() + " " + cs.getProfessorId();
                        System.out.println(message);
                    }
                    System.out.println();
                    break;
                case 5 :
                    List<Course> courseList = viewAllCourses();
                    System.out.println("All Courses : ");
                    System.out.println("ID Name Fee ProfID");
                    for (Course cs : courseList) {
                        message = cs.getCourseId() + "  " + cs.getCourseName() + "   " + cs.getFee() + " " + cs.getProfessorId();
                        System.out.println(message);
                    }
                    System.out.println();
                    break;

                default:
                    logger.info("No operations");
                    break;

            }
        }
    }
}
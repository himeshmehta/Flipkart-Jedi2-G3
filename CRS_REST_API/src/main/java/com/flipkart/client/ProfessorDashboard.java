package com.flipkart.client;

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
        professorServices = new ProfessorServices(new CourseDB());
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
            return professorServices.viewEnrolledCourses(professor.getUserId());
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

    public void addGrades(Integer courseId,Integer marks,Integer studentId) throws Exception {
        GradeCardServices gradeCardServices = new GradeCardServices();
        // add grades
        gradeCardServices.addGrade(professor.getUserId(),courseId,marks,studentId);
    }

    public void helper()
    {

        Scanner inputReader = new Scanner(System.in);
        Boolean result;
        while (true) {
            showMenu();
            int operation = inputReader.nextInt();
            if (operation == 6){
                System.out.println("Exiting from student dashboard");
                break;
            }

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
                    System.out.println("Names of enrolled Students");
                    for (Student student : studentList) {
                        System.out.println( student.getUserId() + "  " +student.getName());
                    }
                    System.out.println("\n");
                    logger.info(message);
                    break;

                case 3:
                    addGradesHandler(inputReader);
                    break;
                case 4 :
                    List<Course> list = viewSelectedCourses();
                    System.out.println("Enrolled Courses : ");
                    System.out.println("ID Name Fee ProfID");
                    for (Course cs : list) {
                        message = cs.getCourseId() + "  " + cs.getCourseName() + "   " + cs.getFee() + " " + cs.getProfessorId();
                        System.out.println(message);
                    }
                    System.out.println("\n");
                    break;
                case 5 :
                    List<Course> courseList = viewAllCourses();
                    System.out.println("All Courses : ");
                    System.out.println("ID Name Fee ProfID");
                    for (Course cs : courseList) {
                        message = cs.getCourseId() + "  " + cs.getCourseName() + "   " + cs.getFee() + " " + cs.getProfessorId();
                        System.out.println(message);
                    }
                    System.out.println("\n");
                    break;

                default:
                    logger.info("No operations");
                    System.out.println("\n");
                    break;

            }
        }
    }

    private void showMenu() {
        System.out.println("Select operation to perform");
        System.out.println("1. Select course to teach");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Add Grades");
        System.out.println("4. View Selected Courses");
        System.out.println("5. View All Courses");
        System.out.println("6. Exit\n");
    }

    private void addGradesHandler(Scanner inputReader) {
        try{
            System.out.println("Enter course id for which you want to add grades.");
            int courseId = inputReader.nextInt();
            List<Student> enrolledStudents = getEnrolledStudents(courseId);

            if(enrolledStudents == null || enrolledStudents.isEmpty()){
                System.out.println("No students registered for this course.");
                return ;
            }
            System.out.println("Following Students are enrolled for course " + courseId);
            for(Student student : enrolledStudents){
                System.out.println(student.getUserId());
            }
            System.out.println("Enter student Id");
            int studentId = inputReader.nextInt();

            System.out.println("Enter grades. Grades should be in range of 0 to 100");
            int grades = inputReader.nextInt();

            addGrades(courseId,grades,studentId);

            System.out.println("Grades added successfully.");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            System.out.println("Grades not added.");
        }
    }
}
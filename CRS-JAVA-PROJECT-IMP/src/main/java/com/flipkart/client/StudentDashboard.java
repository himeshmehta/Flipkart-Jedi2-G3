package com.flipkart.client;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDB;
import com.flipkart.services.CourseRegistrationServices;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class StudentDashboard {
    Student student;
    CourseRegistrationServices courseRegistrationServices;
    StudentDB studentDB;
    private static final Logger logger = Logger.getLogger(String.valueOf(StudentDashboard.class));

    public StudentDashboard(Student student) {
        this.student = student;
        courseRegistrationServices = new CourseRegistrationServices();
        this.studentDB = new StudentDB();
    }

    public Boolean registerCourse(Integer courseId) {
        try {
            return courseRegistrationServices.registerCourse(student, courseId);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean addCourse(Integer courseId) {
        try {
            return courseRegistrationServices.addCourse(student, courseId);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public Boolean removeCourse(Integer courseId) {
        try {
            return courseRegistrationServices.removeCourse(student, courseId);
        } catch (CourseRegistrationException ex) {
            ex.printStackTrace();
            return Boolean.FALSE;
        }
    }

    public List<Course> getRegisteredCourses() {
        return studentDB.registeredCourses(student);
    }

    public void helper() {


        Scanner scanner = new Scanner(System.in);
        Integer courseId;
        Boolean response;
        String message;

        while(true) {
            showMenu();
            int operation = scanner.nextInt();

            try {
                switch (operation) {
                    case 1:
                        logger.info("Enter the Course ID");
                        courseId = scanner.nextInt();
                        response = registerCourse(courseId);
                        message = response ? "Registration Successful" : "Registration failed";
                        logger.info(message);
                        break;
                    case 2:
                        logger.info("Enter the Course ID");
                        courseId = scanner.nextInt();
                        response = removeCourse(courseId);
                        message = response ? "Course removed Successfully" : "Course removal failed";
                        logger.info(message);
                        break;
                    case 3:
                        logger.info("Enter the Course ID");
                        courseId = scanner.nextInt();
                        response = addCourse(courseId);
                        message = response ? "Course added Successfully" : "Course addition failed";
                        logger.info(message);
                        break;
                    case 4:
                        List<Course> courseList = getRegisteredCourses();
                        logger.info("Enrolled Courses : ");
                        for (Course course : courseList) {
                            message = course.getCourseId() + " " + course.getCourseName() + " " + course.getFee() + " " + course.getProfessorId();
                            logger.info(message);
                        }
                    default:
                        break;
                }

                if(operation == 5){
                    // Exit from student dashboard
                    break;
                }
            } catch (Exception ex){
                logger.info(ex.getMessage());
                System.out.println("An error occurred in last operation, Do you want to continue? Enter YES or NO." );
                String yesOrNo = scanner.next();
                if ("NO".equals(yesOrNo)){
                    break;
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu for student dashboard :- ");
        System.out.println("1. Register for Course.");
        System.out.println("2. Remove course.");
        System.out.println("3. Add course to select study.");
        System.out.println("4. Get list of enrolled courses.");
        System.out.println("5. Exit");
        System.out.println("\n\n");
        System.out.println("Enter operation id");
    }
}
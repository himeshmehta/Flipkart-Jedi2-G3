package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.exception.AuthorizationException;
import com.flipkart.services.AuthDBServices;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;



public class CRSApplication {
    private static final Logger logger = Logger.getLogger(String.valueOf(CRSApplication.class));
    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        logger.info("Enter your userId or email");
        String userId = inputReader.next();
        logger.info("Enter your password");
        String password = inputReader.next();

        AuthDBServices authenticateService = new AuthDBServices();
        User user;
        try {
            user = authenticateService.authenticateUser(userId, password);


            if (user.getRole().equals(Role.ADMIN)) {
                // go to admin dashboard
                AdminDashboard dashboard = new AdminDashboard(user);

                while (true) {
                    logger.info("Select operation to perform");
                    int operation = inputReader.nextInt();
                    if (operation == -1) break;

                    switch (operation) {
                        case 1:
                            // add user
                            String name = inputReader.next();
                            String email = inputReader.next();
                            String passs = inputReader.next();

                            Boolean result = dashboard.addUser(email, passs, Role.STUDENT, name);

                            String message = result ? "User added successfully" : "User not added";
                            logger.info(message);
                            break;

                        case 2:
                            // remove user
                            name = inputReader.next();
                            email = inputReader.next();

                            result = dashboard.removeUser(email, Role.STUDENT, name);

                            message = result ? "User removed successfully" : "User not removed";
                            logger.info(message);
                            break;

                        case 3:
                            // add new course
                            String courseID = inputReader.next();
                            String courseName = inputReader.next();

                            result = dashboard.addNewCourse(courseID, courseName);

                            message = result ? "Course added successfully" : "Course not added";
                            logger.info(message);
                            break;

                        default:
                            logger.info("No operations");
                            break;

                    }
                }
            }

        }
        catch(AuthorizationException ex)
        {

        }
    }
}

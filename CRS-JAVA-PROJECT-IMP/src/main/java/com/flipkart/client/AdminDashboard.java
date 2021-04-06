package com.flipkart.client;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.bean.Admin;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.services.AdminServices;

import java.util.Scanner;
import java.util.logging.Logger;

public class AdminDashboard {
    Admin admin;
    AdminServices adminService;
    private static final Logger logger = Logger.getLogger(String.valueOf(AdminDashboard.class));
    public AdminDashboard(Admin admin){
        this.admin = admin;
        adminService = new AdminServices();
    }

    public Boolean addUser(String email, String password, Role role, String name){
        User newUser = new User(name,email,role);
        Boolean isUserAdded = adminService.addUser(newUser,password);
        return isUserAdded;
    }

    public Boolean removeUser(String email,Role role, String name){
        User newUser = new User(name,email,role);
        Boolean isUserRemoved = adminService.removeUser(newUser);
        return isUserRemoved;
    }

    public Boolean addNewCourse(String courseId , String courseName , Long fee){
        return Boolean.TRUE;
    }

    public Boolean approveStudent(String studentId) {
        Boolean isApproved = Boolean.FALSE; // Initially assume that operation is not successful
        try {
            isApproved = adminService.approveStudent(studentId);
        } catch ( ApprovalFailedException e) {
            e.printStackTrace();
        }


        return isApproved;
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

                        String name = inputReader.next();
                        String email = inputReader.next();
                        String passs = inputReader.next();

                        result = addUser(email, passs, Role.STUDENT, name);

                        String message = result ? "User added successfully" : "User not added";
                        logger.info(message);
                        break;

                    case 2:

                        name = inputReader.next();
                        email = inputReader.next();

                        result = removeUser(email, Role.STUDENT, name);

                        message = result ? "User removed successfully" : "User not removed";
                        logger.info(message);
                        break;

                    case 3:

                        String courseId = inputReader.next();
                        String courseName = inputReader.next();
                        long fee=inputReader.nextLong();

                        result = addNewCourse(courseId, courseName,fee);

                        message = result ? "Course added successfully" : "Course not added";
                        logger.info(message);
                        break;

                    default:
                        logger.info("No operations");
                        break;

                }
                inputReader.close();
            }
        }
    }



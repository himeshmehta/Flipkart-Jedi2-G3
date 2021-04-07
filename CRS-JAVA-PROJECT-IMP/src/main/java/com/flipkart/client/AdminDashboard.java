package com.flipkart.client;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Admin;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.services.AdminServices;

import java.util.ArrayList;
import java.util.List;
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
        Boolean isUserAdded = Boolean.FALSE;
        try {
            isUserAdded = adminService.addUser(newUser,password);
        } catch (CRSException | InvalidDataException e) {
            System.out.println(e.getMessage());
            logger.info(e.getMessage());
        }
        return isUserAdded;
    }

    public  Boolean removeUser(int userId){
        Boolean isUserRemoved = Boolean.FALSE;
        try {
            adminService.removeUser(userId);
            isUserRemoved = Boolean.TRUE;
        } catch (CRSException e) {
            System.out.println(e.getMessage());
            logger.info(e.getMessage());
        }
        return isUserRemoved;
    }

    public Boolean addNewCourse(int courseId , String courseName , Long fee){
        return Boolean.TRUE;
    }

    public void getListOfSelfRegisteredStudent(){
        try {
            List<Integer> userIds = adminService.getNotApprovedStudents();
            if(userIds != null && userIds.size() > 0){
                System.out.println("Following students are not approved.");
            } else{
                System.out.println("All students are approved.");
            }
            String users = "";
            for(int userId : userIds){
                users = users + String.valueOf(userId) + ' ';
            }
            System.out.println(users);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void approveListOfStudent(List<Integer> userIds) {
        for(int studentId : userIds){
            try{
                adminService.approveStudent(studentId);
                System.out.println("Student with id " + String.valueOf(studentId) + " approved and notification sent.");
            } catch(CRSException e){
                System.out.println("Student with id " + String.valueOf(studentId) + " not approved.");
            }
        }
    }

    public void helper()
    {
        Scanner inputReader = new Scanner(System.in);
        Boolean result;

        while (true) {
            try{
                System.out.println("Select operation to perform");
                System.out.println("1. Add User");
                System.out.println("2. Remove User");
                System.out.println("3. Add New Course");
                System.out.println("4. Approve Student");
                System.out.println("5. Exit");
                int operation = inputReader.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter name of new user");
                        String name = inputReader.next();

                        System.out.println("Enter email of new user");
                        String email = inputReader.next();

                        System.out.println("Enter Password for new user");
                        String passs = inputReader.next();

                        System.out.println("Enter role for new user\n 1 --> Student \n 2 --> Admin \n 3 --> Professor");
                        int role = inputReader.nextInt();
                        Role rUser = null;
                        switch (role){
                            case 1:
                                rUser = Role.STUDENT;
                                break;
                            case 2:
                                rUser = Role.ADMIN;
                                break;
                            case 3:
                                rUser = Role.PROFESSOR;
                                break;
                        }
                        result = addUser(email, passs, rUser, name);

                        String message = result ? "User added successfully" : "User not added";
                        System.out.println(message);
                        break;

                    case 2:
                        System.out.println("Enter user id of the user.");
                        int userId = inputReader.nextInt();

                        result = removeUser(userId);

                        message = result ? "User removed successfully" : "User not removed";
                        System.out.println(message);
                        break;

                    case 3:

                        System.out.println("Enter Course Description");
                        int courseId = inputReader.nextInt();
                        System.out.println("Enter Course Name");
                        String courseName = inputReader.next();
                        long fee=inputReader.nextLong();

                        result = addNewCourse(courseId, courseName,fee);

                        message = result ? "Course added successfully" : "Course not added";
                        System.out.println(message);
                        break;

                    case 4:
                        // show not approved list
                        getListOfSelfRegisteredStudent();
                        List<Integer> ids = new ArrayList<>();
                        System.out.println("Enter student ids in a new line.Enter -1 to stop.");
                        int id = inputReader.nextInt();
                        while(id != -1){
                            ids.add(id);
                            id = inputReader.nextInt();
                        }
                        if(!ids.isEmpty()) approveListOfStudent(ids);
                        break;
                    case 5:
                        System.out.println("Exiting from Admin dashboard.");
                        break;
                    default:
                        logger.info("No operations");
                        break;

                }
                if (operation == 5) break;
            } catch(Exception e){
                System.out.println( "ERROR --> "+ e.getMessage());
            }

        }
        inputReader.close();
        }
    }



package com.flipkart.dashboard;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Admin;
import com.flipkart.bean.User;
import com.flipkart.constants.RoleEnum;
import com.flipkart.services.AdminServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The type admin dashboard
 */
public class AdminDashboard {
    Admin admin;
    AdminServices adminService;
    private static final Logger logger = Logger.getLogger(String.valueOf(com.flipkart.dashboard.AdminDashboard.class));

    /**
     * Constructor of adminaDashboard
     * @param admin admin
     */
    public AdminDashboard(Admin admin){
        this.admin = admin;
        adminService = new AdminServices();
    }


    /**
     * This method is used to add user
     * @param email email
     * @param password password
     * @param roleEnum role
     * @param name name
     * @return boolean
     */
    public Boolean addUser(String email, String password, RoleEnum roleEnum, String name){
        User newUser = new User(name,email, roleEnum);
        Boolean isUserAdded = Boolean.FALSE;
        try {
            adminService.addUser(newUser,password);
            isUserAdded = Boolean.TRUE;
        } catch (CRSException | InvalidDataException e) {
            logger.info(e.getMessage());
        }
        return isUserAdded;
    }

    /**
     * This method is used to remove user
     * @param userId user id
     * @return boolean
     */
    public  Boolean removeUser(int userId){
        Boolean isUserRemoved = Boolean.FALSE;
        try {
            adminService.removeUser(userId);
            isUserRemoved = Boolean.TRUE;
        } catch (CRSException e) {
            logger.info(e.getMessage());
        }
        return isUserRemoved;
    }

    /**
     * This method is used to add new new course
     * @param description description
     * @param courseName course name
     * @param fee feee
     * @return boolean
     */
    public Boolean addNewCourse(String description , String courseName , Long fee){
        Boolean newCourseAdded = Boolean.FALSE;
        try {
            adminService.addNewCourse(description,courseName,fee);
            newCourseAdded = Boolean.TRUE;
        } catch (Exception ex){
            logger.info(ex.getMessage());
        }
        return newCourseAdded;
    }

    /**
     * This method is used to get the list of registered but not approved students
     */
    public void getListOfSelfRegisteredStudent(){
        try {
            List<Integer> userIds = adminService.getNotApprovedStudents();
            if(userIds != null && userIds.size() > 0){
                logger.info("Following students are not approved.");
            } else{
                logger.info("All students are approved.");
            }
            String users = "";
            for(int userId : userIds){
                users = users + String.valueOf(userId) + ' ';
            }
            logger.info(users);
        } catch (Exception e){
           logger.info(e.getMessage());
        }
    }

    /**
     * This method is used to approve registerd students
     * @param userIds users id
     */
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

    /**
     * This method is used to perform admin operations
     * @param inputReader input reader
     */
    public void helper(Scanner inputReader)
    {
        // Scanner inputReader = new Scanner(System.in);
        Boolean result;

        while (true) {
            try{
                showMenu();
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
                        RoleEnum rUser = null;
                        switch (role){
                            case 1:
                                rUser = RoleEnum.STUDENT;
                                break;
                            case 2:
                                rUser = RoleEnum.ADMIN;
                                break;
                            case 3:
                                rUser = RoleEnum.PROFESSOR;
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
                        String description = inputReader.next();

                        System.out.println("Enter Course Name");
                        String courseName = inputReader.next();

                        System.out.println("Enter fee for the course");
                        long fee=inputReader.nextLong();

                         Boolean newCourseAdded = addNewCourse(description, courseName,fee);

                        message = newCourseAdded == Boolean.FALSE ? "Course not added" : "Course added successfully";
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
    }

    /**
     * This method is used to show the list of operations
     */
    private void showMenu() {
        System.out.println("Select operation to perform");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. Add New Course");
        System.out.println("4. Approve Student");
        System.out.println("5. Exit");
    }
}



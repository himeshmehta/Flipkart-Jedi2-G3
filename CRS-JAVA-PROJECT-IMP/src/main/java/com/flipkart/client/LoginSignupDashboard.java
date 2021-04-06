package com.flipkart.client;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.services.AuthDBServices;

import java.util.Scanner;

public class LoginSignupDashboard {
    private static AuthDBServices authServices = new AuthDBServices();

    public static User LoginUser() throws CRSException {
        User user = null;
        Scanner inputReader = null;
        try{
            inputReader = new Scanner(System.in);
            System.out.println("Enter your userId");
            String userId = inputReader.nextLine();
            System.out.println("Enter your password");
            String password = inputReader.nextLine();

            // Authenticate user
            user = authServices.authenticateUser(userId,password);

            Role roleOfUser = user.getRole();

            // Now go to different dashboard according to different roles

            switch (roleOfUser){
                case ADMIN:
                    new AdminDashboard((Admin) (user)).helper();
                    break;
                case STUDENT:
                    new StudentDashboard((Student) (user)).helper();
                    break;
                case PROFESSOR:
                    new ProfessorDashboard((Professor) (user)).helper();
                    break;
                default:
                    throw new CRSException("You can not log in here.");
            }
            inputReader.close();
        } catch (Exception e) {
            inputReader.close();
            throw new CRSException(e.getMessage());
        }

        return user;
    }

    public static void SignUpUser() throws CRSException {
        Scanner inputReader = new Scanner(System.in);

        try {
            Boolean isSignUpComplete = false; // Initially assume sign is not completed

            System.out.println("Sign up is only available for students. Do you want proceed further? Enter YES or NO");

            String operation = inputReader.nextLine();

            if ("YES".equals(operation)){

                while(!isSignUpComplete){
                    System.out.println("Enter your email.");
                    String email = inputReader.nextLine();

                    System.out.println("Enter your name.");
                    String name = inputReader.nextLine();

                    System.out.println("Enter your password");
                    String password = inputReader.nextLine();

                    System.out.println("Enter your password again");
                    String confirmPassword = inputReader.nextLine();

                    try {
                        isSignUpComplete = authServices.selfRegisterStudent(email,name,password,confirmPassword);
                    } catch (Exception e){
                        isSignUpComplete = false;
                        System.out.println(e.getMessage());
                    }

                    if(!isSignUpComplete){
                        System.out.println("Signup failed. Do you want to try again? Enter YES or NO.");
                        String op = inputReader.nextLine();
                        if("NO".equals(op)){
                            break;
                        }
                    }
                }
            }
            if (!isSignUpComplete) {
                throw new CRSException("SignUp is not completed");
            }
            else {
                System.out.println("Sign up is completed. You can only login once admin approve your request.");
            }
            inputReader.close();
        } catch (Exception e) {
            inputReader.close();
            throw new CRSException(e.getMessage());
        }
    }
}

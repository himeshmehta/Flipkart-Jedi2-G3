package com.flipkart.dashboard;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.RoleEnum;
import com.flipkart.services.AuthDBServices;

import java.util.Scanner;

/**
 * The type login and signup dashboard
 */
public class LoginSignupDashboard {
    private static AuthDBServices authServices = new AuthDBServices();

    /**
     * This method is used for user login
     * @throws CRSException
     */
    public static void LoginUser() throws CRSException {
        User user = null;
        Scanner inputReader = new Scanner(System.in);

        while(true){
            try{
                System.out.println("Enter your userId");
                int userId = inputReader.nextInt();
                System.out.println("Enter your password");
                String password = inputReader.next();

                // Authenticate user
                user = authServices.authenticateUser(userId,password);

                RoleEnum roleOfUser = user.getRole();
                // Now go to different dashboard according to different roles

                switch (roleOfUser){
                    case ADMIN:
                        new AdminDashboard(new Admin(user)).helper(inputReader);
                        break;
                    case STUDENT:
                        new StudentDashboard(new Student(user)).helper();
                        break;
                    case PROFESSOR:
                        new ProfessorDashboard(new Professor(user)).helper();
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERROR --> " + e.getMessage());
            }

            // Ask if user want to log in again
            System.out.println("Do you want to login again? Enter YES or NO.");
            String yesOrNo = inputReader.next();

            if("NO".equals(yesOrNo)){
                System.out.println("Exiting from Login dashboard");
                break;
            }
        }
        inputReader.close();
    }

    /**
     * This method is used for user registration
     * @throws CRSException
     */
    public static void SignUpUser() throws CRSException {
        Scanner inputReader = new Scanner(System.in);

        try {
            User user = null;

            System.out.println("Sign up is only available for students. Do you want proceed further? Enter YES or NO");

            String operation = inputReader.nextLine();

            if ("YES".equals(operation)){

                while(user == null){
                    System.out.println("Enter your email.");
                    String email = inputReader.nextLine();

                    System.out.println("Enter your name.");
                    String name = inputReader.nextLine();

                    System.out.println("Enter your password");
                    String password = inputReader.nextLine();

                    System.out.println("Enter your password again");
                    String confirmPassword = inputReader.nextLine();

                    try {
                        user = authServices.selfRegisterStudent(email,name,password,confirmPassword);
                    } catch (Exception e){
                        user = null;
                        System.out.println(e.getMessage());
                    }

                    if(user == null){
                        System.out.println("Signup failed. Do you want to try again? Enter YES or NO.");
                        String op = inputReader.nextLine();
                        if("NO".equals(op)){
                            break;
                        }
                    }
                }
            }
            if (user == null) {
                throw new CRSException("SignUp is not completed");
            }
            else {
                System.out.println("Sign up is completed. You can only login once admin approve your registration request.");
            }
            inputReader.close();
        } catch (Exception e) {
            inputReader.close();
            throw new CRSException(e.getMessage());
        }
    }
}

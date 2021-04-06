package com.flipkart.client;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.User;

import java.util.Scanner;
import java.util.logging.Logger;

public class CRSApplication {
    private static final Logger logger = Logger.getLogger(String.valueOf(CRSApplication.class));
    public static void main(String[] args) {

        Scanner inputReader = null;
        try{
            logger.info("In login page");
            inputReader = new Scanner(System.in);
            System.out.println("Do you want to login or signup?");
            String loginOrSignup = inputReader.nextLine();

            User user = null;
            switch(loginOrSignup){
                case "login":
                    user = LoginSignupDashboard.LoginUser();
                    System.out.println(user.getRole());
                    break;
                case "signup":
                    LoginSignupDashboard.SignUpUser();
                    break;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
            inputReader.close();
        } catch(CRSException e){
            inputReader.close();
            logger.info(e.getMessage());
        }
    }
}
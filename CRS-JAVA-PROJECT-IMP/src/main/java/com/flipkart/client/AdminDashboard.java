package com.flipkart.client;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.helper.UserValidator;
import com.flipkart.services.AdminServices;

public class AdminDashboard {
    User admin;
    AdminServices adminService;

    public AdminDashboard(User admin){
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

    public Boolean addNewCourse(String courseId,String courseName){
        return Boolean.TRUE;
    }

    public Boolean approveStudent(String studentId) {
        Boolean isApproved = Boolean.FALSE; // Initially assume that operation is not successful
        try {
            // userId will be same to email
            UserValidator.emailValidator(studentId);
            isApproved = adminService.approveStudent(studentId);
        } catch (InvalidDataException | ApprovalFailedException e) {
            e.printStackTrace();
        }


        return isApproved;
    }

}

package com.flipkart.client;

import com.flipkart.bean.Admin;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.exception.UserAlreadyAddedException;
import com.flipkart.exception.UserNotPresetException;
import com.flipkart.services.AdminServices;

public class AdminDashboard {
    User admin;
    AdminServices adminService;

    public AdminDashboard(User admin){
        this.admin = admin;
        adminService = new AdminServices();
    }

    public Boolean addUser(String email, String password, Role role, String name) throws UserAlreadyAddedException {
        User newUser = new User(name,email,role);
        Boolean isUserAdded = adminService.addUser(newUser,password);
        return isUserAdded;
    }

    public Boolean removeUser(String email,Role role, String name) throws UserNotPresetException {
        User newUser = new User(name,email,role);
        Boolean isUserRemoved = adminService.removeUser(newUser);
        return isUserRemoved;
    }

    public Boolean addNewCourse(String courseId,String courseName){
        return Boolean.TRUE;
    }

}

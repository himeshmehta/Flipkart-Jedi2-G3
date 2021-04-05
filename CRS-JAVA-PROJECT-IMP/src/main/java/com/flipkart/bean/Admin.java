package com.flipkart.bean;

import com.flipkart.constants.Role;

import javax.jws.soap.SOAPBinding;

public class Admin extends User {

    private String adminId;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Admin(String name, String email, Role role, String adminId) {
        super(name, email, role);
        this.adminId = adminId;
    }
}

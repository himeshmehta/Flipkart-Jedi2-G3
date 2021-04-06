package com.flipkart.bean;

import com.flipkart.constants.Role;

public class Admin extends User {

    private String adminId;

    /**
     * Gets the admin id
     * @return admin id
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * Sets the admin id
     * @param adminId admin id
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Admin(String name, String email, Role role, String adminId) {
        super(name, email, role);
        this.adminId = adminId;
    }
}

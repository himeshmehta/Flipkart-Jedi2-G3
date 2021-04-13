package com.flipkart.src.main.java.com.flipkart.constants;

public enum RoleEnum {
    STUDENT,
    PROFESSOR,
    ADMIN;

    public String getRole() {
        return this.name();
    }

}

package com.flipkart.constants;

public enum Role {
    STUDENT,
    PROFESSOR,
    ADMIN;

    public String getRole() {
        return this.name();
    }

}

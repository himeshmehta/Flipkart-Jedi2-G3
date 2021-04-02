package com.flipkart.bean;

import com.flipkart.constants.Role;

import java.util.*;

public class Student extends User{
    private String studentId;

    public Student(String name, String email, Role role) {
        super(name, email, role);
    }
}

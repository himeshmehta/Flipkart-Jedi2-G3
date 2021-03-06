package com.flipkart.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * All database schema is present here.
 * */


public class DBSchema {

    public static String userTable = "create table if not exists user (\n" +
            "userId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "email VARCHAR(100) NOT NULL,\n" +
            "name VARCHAR(100) NOT NULL,\n" +
            "password VARCHAR(100) NOT NULL,\n" +
            "isApproved BOOLEAN,\n" +
            "role enum('Student', 'Admin', 'Professor')\n" +
            ");";

    public static String studentTable = "create table if not exists student(\n" +
            "email VARCHAR(100) PRIMARY KEY,\n" +
            "name VARCHAR(100) NOT NULL\n" +
            ");";

    public static String adminTable = "create table if not exists admin(\n" +
            "email VARCHAR(100) PRIMARY KEY,\n" +
            "name VARCHAR(100) NOT NULL\n" +
            ");";

    public static String profTable = "create table if not exists professor(\n" +
            "email VARCHAR(100) PRIMARY KEY,\n" +
            "name VARCHAR(100) NOT NULL\n" +
            ");";

    public static String notificationTable = "create table if not exists notification (\n" +
            "notificationId INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "description VARCHAR(255) NOT NULL,\n" +
            "receiverId INT,\n" +
            "time TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
            ");";

    public static String courseTable = "create table if not exists course(\n" +
            "courseId INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "coursename VARCHAR(255) NOT NULL,\n" +
            "description VARCHAR(100) NOT NULL,\n" +
            "userId INT,\n" +
            "isValid Boolean,\n" +
            "fee INT NOT NULL,\n" +
            "FOREIGN KEY (userId) REFERENCES user(userId)\n" +
            ");";

    public static String paymentTable = "create table if not exists payment(\n" +
            "referenceId VARCHAR(50) PRIMARY KEY,\n" +
            "description VARCHAR(255),\n" +
            "amount INT NOT NULL,\n" +
            "studentId INT DEFAULT NULL,\n"+
            "method enum('DEBIT','CREDIT','OFFLINE') NOT NULL\n" +
            ");";

    public static String courseRegistration = "create table if not exists registeredcourses(\n" +
            "studentId INT NOT NULL,\n" +
            "courseId INT NOT NULL,\n" +
            "isFeePaid Boolean NOT NULL DEFAULT 0,\n"+
            "PRIMARY KEY (studentId, courseId)\n" +
            ");";

    public static String gradeCard = "create table if not exists gradeCard(\n" +
            "studentId INT NOT NULL,\n" +
            "courseId INT NOT NULL,\n" +
            "grade INT ,\n" +
            "PRIMARY KEY (studentId, courseId),\n" +
            "FOREIGN KEY (studentId) REFERENCES user(userId),\n" +
            "FOREIGN KEY (courseId) REFERENCES course(courseId)\n" +
            ");";

    /**
     * This method returns list of create table query for all tables.
     * Error can generate related to foreign key if tables are not created and dropped in below fashion.
     * To create tables :- forward direction
     * To drop tables   :- reverse direction*/
    public static List<String> getQueries() {
        List<String> queries = new ArrayList<String>();
        queries.add(userTable);
        queries.add(studentTable);
        queries.add(profTable);
        queries.add(adminTable);
        queries.add(courseTable);
        queries.add(courseRegistration);
        queries.add(notificationTable);
        queries.add(paymentTable);
        queries.add(gradeCard);

        return queries;
    }
}

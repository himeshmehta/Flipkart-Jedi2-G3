package com.flipkart.constants;

import java.util.ArrayList;
import java.util.List;

public class CreateTable {

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
            "time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
            "FOREIGN KEY (receiverId) REFERENCES user(userId)\n" +
            ");";

    public static String courseTable = "create table if not exists course(\n" +
            "courseId INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "courseName VARCHAR(20) NOT NULL,\n" +
            "description VARCHAR(100) NOT NULL,\n" +
            "professorId INT NOT NULL,\n" +
            "isValid Boolean,\n" +
            "fee INT NOT NULL,\n" +
            "FOREIGN KEY (professorId) REFERENCES user(userId)\n" +
            ");";

    public static String paymentTable = "create table if not exists payment(\n" +
            "referenceId INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "description VARCHAR(100),\n" +
            "amount INT NOT NULL,\n" +
            "method enum('DEBIT','CREDIT','OFFLINE') NOT NULL\n" +
            ");";

    public static String courseRegistration = "create table if not exists courseRegistration(\n" +
            "studentId INT NOT NULL,\n" +
            "courseId INT NOT NULL,\n" +
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

    public static List<String> getQueries() {
        List<String> queries = new ArrayList<>();
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

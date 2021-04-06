package com.flipkart.constants;

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
}

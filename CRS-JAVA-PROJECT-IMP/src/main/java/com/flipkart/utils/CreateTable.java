package com.flipkart.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();
            System.out.println(1);
            String createTable = "create table if not exists User (\n" +
                    "userId VARCHAR(100) NOT NULL,\n" +
                    "email VARCHAR(100) NOT NULL,\n" +
                    "name VARCHAR(100) NOT NULL,\n" +
                    "password VARCHAR(100) NOT NULL,\n" +
                    "isApproved Boolean,\n" +
                    "role enum('Student', 'Admin', 'Professor'),\n" +
                    "PRIMARY KEY (userId)\n" +
                    ");";

            stmt = connection.prepareStatement(createTable);
            System.out.println(2);
            int rs = stmt.executeUpdate();
            System.out.println(3);
            System.out.println(rs);
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


package com.flipkart.utils;


import com.flipkart.constants.CreateTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

class CreateTableScript {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();
            System.out.println(1);
            DropTables(connection,stmt);
            List<String> createTableQueries = CreateTable.getQueries();

            for(String s : createTableQueries){
                stmt = connection.prepareStatement(s);
                stmt.executeUpdate();
                stmt.close();
            }
//            // user table
//            String table = CreateTable.userTable;
//            stmt = connection.prepareStatement(table);
//            System.out.println(2);
//            int rs = stmt.executeUpdate();
//            System.out.println(3);
//            System.out.println(rs);
//            stmt.close();
//
//            table = CreateTable.studentTable;
//            stmt = connection.prepareStatement(table);
//            rs = stmt.executeUpdate();
//            stmt.close();
//
//            table = CreateTable.adminTable;
//            stmt = connection.prepareStatement(table);
//            rs = stmt.executeUpdate();
//            stmt.close();
//
//            table = CreateTable.profTable;
//            stmt = connection.prepareStatement(table);
//            rs = stmt.executeUpdate();
//            stmt.close();
//
//            table = CreateTable.notificationTable;
//            stmt = connection.prepareStatement(table);
//            rs = stmt.executeUpdate();
//            stmt.close();

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void DropTables(Connection conn,PreparedStatement stmt) throws SQLException {
        String drop = "DROP TABLE IF EXISTS ";
        String[] tables ={"gradeCard","courseRegistration","course","notification","user","student","admin","professor","payment"};

        for(String table : tables){
            System.out.println("deleting " + table);
            String t = drop + table;
            stmt = conn.prepareStatement(t);
            stmt.executeUpdate();
            stmt.close();
        }

    }
}


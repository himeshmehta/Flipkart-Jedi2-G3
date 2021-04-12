package com.flipkart.utils;


import com.flipkart.constants.CreateTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is used to create/drop all tables related to this project.
 */

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
                // if ( s != CreateTable.paymentTable ) continue;
                stmt = connection.prepareStatement(s);
                stmt.executeUpdate();
                stmt.close();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void DropTables(Connection conn,PreparedStatement stmt) throws SQLException {
        String drop = "DROP TABLE IF EXISTS ";
        String[] tables ={"gradeCard","registeredcourses","course","notification","user","student","admin","professor","payment"};

        for(String table : tables){
            // if ( table != "payment" ) continue;
            System.out.println("deleting " + table);
            String t = drop + table;
            stmt = conn.prepareStatement(t);
            stmt.executeUpdate();
            stmt.close();
        }

    }
}


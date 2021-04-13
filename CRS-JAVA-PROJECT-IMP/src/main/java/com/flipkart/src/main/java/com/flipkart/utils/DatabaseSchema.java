package com.flipkart.src.main.java.com.flipkart.utils;


import com.flipkart.constants.DBSchema;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is used to create/drop all tables related to this project.
 */

class DatabaseSchema {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();
            DropTables(connection,stmt);
            List<String> createTableQueries = DBSchema.getQueries();

            for(String s : createTableQueries){
                stmt = connection.prepareStatement(s);
                stmt.executeUpdate();
                stmt.close();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This method is used to drop tables.
     * Do not changes the order of tables.
     * This order need to follow otherwise there will be error related to foreign key.*/
    private static void DropTables(Connection conn,PreparedStatement stmt) throws SQLException {
        String drop = "DROP TABLE IF EXISTS ";
        String[] tables ={"gradeCard","registeredcourses","course","notification","user","student","admin","professor","payment"};

        for(String table : tables){
            String t = drop + table;
            stmt = conn.prepareStatement(t);
            stmt.executeUpdate();
            stmt.close();
        }

    }
}


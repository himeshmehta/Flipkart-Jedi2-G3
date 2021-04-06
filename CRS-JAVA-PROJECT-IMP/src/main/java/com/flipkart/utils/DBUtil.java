package com.flipkart.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    private static Connection connection = null;
    /**
     *
     This method is used for the connection with the Database.
     @Param - None
     @Throws - Nothing
     @returns - Connection with the server

     **/

    public static Connection getConnection() {

        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                System.out.println('a');
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("./config.properties");
                System.out.println(inputStream);
                prop.load(inputStream);
                System.out.println('c');
                String driver = prop.getProperty("driver");
                System.out.println('d');
                String url = prop.getProperty("url");
                System.out.println('e');
                String user = prop.getProperty("user");
                System.out.println('f');
                String password = prop.getProperty("password");
                System.out.println('g');
                Class.forName(driver);
                System.out.println('h');
                connection = DriverManager.getConnection(url, user, password);
                System.out.println('i');
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}

package com.flipkart.utils;

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
     @param - None
     @throws - Nothing
     @return - Connection with the server
     **/

    public static Connection getConnection() {

        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = com.flipkart.utils.DBUtil.class.getClassLoader().getResourceAsStream("./config.properties");
                // prop.load(inputStream);
                String driver = "com.mysql.jdbc.Driver";//prop.getProperty("driver");
                String url = "jdbc:mysql://localhost:3306/test"; //prop.getProperty("url");
                String user = "root";///prop.getProperty("user");
                String password = "12345"; //prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            return connection;
        }

    }
}

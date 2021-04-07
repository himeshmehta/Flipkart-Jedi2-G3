package com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.NotificationException;
import com.flipkart.bean.Notification;
import com.flipkart.client.AdminDashboard;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class NotificationDB implements NotificationDBInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(AdminDashboard.class));
    private Connection conn = null;
    private PreparedStatement sqlQuery;

    public NotificationDB(){
        conn = DBUtil.getConnection();
        sqlQuery = null;
    }

    @Override
    public  void sendNotificationToUser(Notification notification, int receiverId) throws NotificationException, CRSException {
        try {
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.SEND_NOTIFICATION);
            sqlQuery.setString(1,notification.getDescription());
            sqlQuery.setInt(2,receiverId);
            sqlQuery.setString(3,notification.getTimeStamp());
            int updateRows = sqlQuery.executeUpdate();
            System.out.println(updateRows);
        } catch (SQLException ex) {
            throw new CRSException(ex.getMessage());
        }
    }
}

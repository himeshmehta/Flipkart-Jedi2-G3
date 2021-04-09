package com.flipkart.dao;

import com.flipkart.Exception.PaymentException;
import com.flipkart.bean.Payment;
import com.flipkart.constants.PaymentMode;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDB implements PaymentDBInterface{
    private Connection conn = null;
    private PreparedStatement sqlQuery;

    public PaymentDB(){
        conn = DBUtil.getConnection();
        sqlQuery = null;
    }

    @Override
    public void completePayment(Payment payment) throws PaymentException {
        try {
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.ADD_PAYMENT);
            sqlQuery.setString(1,payment.getReferenceId());
            sqlQuery.setString(2, payment.getPaymentDescription());
            sqlQuery.setInt(3,payment.getAmount());
            sqlQuery.setInt(4,payment.getUserId());
            sqlQuery.setInt(5,getIndexFromPaymentMode(payment.getMode()));
            sqlQuery.executeUpdate();
            sqlQuery.close();
        } catch (SQLException ex) {
            throw new PaymentException(ex.getMessage());
        }
    }

    private int getIndexFromPaymentMode(PaymentMode mode) {
        int modeIndex=0;

        if(PaymentMode.DEBITCARD.equals(mode)){
            modeIndex = 1;
        } else if(PaymentMode.CREDITCARD.equals(mode)){
            modeIndex = 2;
        } else {
            modeIndex = 3;
        }

        return modeIndex;
    }
}

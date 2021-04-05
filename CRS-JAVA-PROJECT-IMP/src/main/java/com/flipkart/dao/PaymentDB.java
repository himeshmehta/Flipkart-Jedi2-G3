package com.flipkart.dao;

import com.flipkart.bean.Offline;
import com.flipkart.bean.Online;
import com.sun.istack.internal.NotNull;

public class PaymentDB implements PaymentDBInterface{

    public  void completeOnlinePayment(@NotNull Online onlinePayment){
        // TODO :- Complete the online payment
    }

    public  void completeOfflinePayment(@NotNull Offline offlinePayment){
        // TODO :- Complete the offline payment
    }
}

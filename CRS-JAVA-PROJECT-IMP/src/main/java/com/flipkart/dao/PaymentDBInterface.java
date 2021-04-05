package com.flipkart.dao;

import com.flipkart.bean.Offline;
import com.flipkart.bean.Online;
import com.sun.istack.internal.NotNull;

public interface PaymentDBInterface {
    /**
     * This method complete the online payment.
     * @Param onlinePayment :- an object of online payment which contains all information regarding payment.
     * @Throws Nothing
     * @return Nothing
     *  */
    public  void completeOnlinePayment(@NotNull Online onlinePayment);

    /**
     * This method complete the offline payment.
     * @Param offlinePayment :- an object of offline payment which contains all information regarding payment.
     * @Throws Nothing
     * @return Nothing
     *  */
    public  void completeOfflinePayment(@NotNull Offline offlinePayment);
}

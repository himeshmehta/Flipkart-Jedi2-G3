package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;


public class AdminServices implements AdminInterface{
    @Override
    public Boolean addUser(User user,String password) {
        Boolean isUserAdded = AuthDB.addNewUser(user,password);
        return isUserAdded;
    }

    @Override
    public Boolean removeUser(User user) {
        Boolean isUserRemoved = AuthDB.removeExistingUser(user);
        return isUserRemoved;
    }

    @Override
    public Boolean approveStudent(final String studentId) throws ApprovalFailedException {
            Boolean isStudentApproved = AuthDB.approveStudent(studentId);
            if(isStudentApproved){
                // create an object of notification service
                NotificationServices notificationServices = new NotificationServices();
                notificationServices.approvalNotifier(studentId);
                return Boolean.TRUE;
            }
            else {
                String message = "Approval failed for Student " + studentId;
                throw new ApprovalFailedException(message);
            }
    }
}

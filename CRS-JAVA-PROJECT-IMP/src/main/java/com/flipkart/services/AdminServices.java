package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;

import java.util.logging.Logger;


public class AdminServices implements AdminInterface{
    private AuthDB authDBOperations;
    public AdminServices(){
        this.authDBOperations = new AuthDB();
    }


    private static final Logger logger = Logger.getLogger(String.valueOf(AdminServices.class));

    @Override
    public Boolean addUser(User user,String password) {
        Boolean isUserAdded = authDBOperations.addNewUser(user,password);
        logger.info("Adding User to the DB");
        return isUserAdded;
    }

    @Override
    public Boolean removeUser(User user) {
        Boolean isUserRemoved = authDBOperations.removeExistingUser(user);
        logger.info("Removing User from the DB");
        return isUserRemoved;
    }

    @Override
    public Boolean approveStudent(final String studentId) throws ApprovalFailedException {
            Boolean isStudentApproved = authDBOperations.approveStudent(studentId);
            if(isStudentApproved){
                // create an object of notification service
                NotificationServices notificationServices = new NotificationServices();
                notificationServices.approvalNotifier(studentId);
                logger.info("Student Already approved");
                return Boolean.TRUE;
            }
            else {
                String message = "Approval failed for Student " + studentId;
                logger.info("Approving Student");
                throw new ApprovalFailedException(message);
            }
    }
}

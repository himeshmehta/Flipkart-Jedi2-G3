package com.flipkart.services;

import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;
import com.flipkart.exception.UserAlreadyAddedException;
import com.flipkart.exception.UserNotPresetException;

import java.util.logging.Logger;

public class AdminServices implements AdminInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(AdminServices.class));

    @Override
    public Boolean addUser(User user,String password) throws UserAlreadyAddedException {
        Boolean isUserAdded = AuthDB.addNewUser(user,password);
        logger.info("Adding User to the DB");
        return isUserAdded;
    }

    @Override
    public Boolean removeUser(User user) throws UserNotPresetException {
        Boolean isUserRemoved = AuthDB.removeExistingUser(user);
        logger.info("Removing User to the DB");
        return isUserRemoved;
    }
}

package com.flipkart.services;

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
}

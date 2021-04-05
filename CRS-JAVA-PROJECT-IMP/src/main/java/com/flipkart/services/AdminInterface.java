package com.flipkart.services;

import com.flipkart.Exception.ApprovalFailedException;
import com.flipkart.bean.User;

public interface AdminInterface {
    public Boolean addUser(User user, String password);

    public Boolean removeUser(User user);

    public Boolean approveStudent(String studentId) throws ApprovalFailedException;
}

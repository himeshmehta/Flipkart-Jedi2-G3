package com.flipkart.src.main.java.com.flipkart.requestPojo;

import com.flipkart.bean.User;

public class NewUserRequest {
    User user;
    String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

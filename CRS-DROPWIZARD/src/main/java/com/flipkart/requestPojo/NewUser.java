package com.flipkart.requestPojo;

import com.flipkart.bean.User;

public class NewUser {
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

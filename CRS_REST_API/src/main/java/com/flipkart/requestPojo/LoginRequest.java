package com.flipkart.requestPojo;

public class LoginRequest {
    private int userId;
    private String password;

    void LoginPojo(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

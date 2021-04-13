package com.flipkart.bean;

import com.flipkart.constants.RoleEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
     The type user
 */
public class User {
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    private RoleEnum roleEnum;
    @NotNull
    private int userId;

    public User() {

    }

    /**
     *  Gets user id
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the user roleEnum
     * @return the user roleEnum
     */
    public RoleEnum getRole() {
        return roleEnum;
    }

    /**
     * Sets the user roleEnum
     * @param roleEnum the user roleEnum
     */
    public void setRole(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public User(String name, String email, RoleEnum roleEnum){
        this.email = email;
        this.name = name;
        this.roleEnum = roleEnum;
    }

    public User(String name, String email, RoleEnum roleEnum, int userId){
        this.email = email;
        this.name = name;
        this.roleEnum = roleEnum;
        this.userId = userId;
    }

    /**
     * Gets the user name
     * @return the user name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user name
     * @param name the user name
     */
    public void setName(String name) {
        this.name = name;
    }

//    public String getUserID() {
//        return userID;
//    }
//
//    public void setUserID(String userID) {
//        this.userID = userID;
//    }

    /**
     * Gets the user email
     * @return the user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user email
     * @param email the user email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
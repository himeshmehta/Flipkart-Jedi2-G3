package com.flipkart.bean;

import com.flipkart.constants.Role;

/**
     The type user
 */
public class User {
    private String name;
    private String email;
    private Role role;
    private String userId;

    /**
     *  Gets user id
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the user role
     * @return the user role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the user role
     * @param role the user role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    public User(String name,String email,Role role){
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public User(String name,String email,Role role,String userId){
        this.email = email;
        this.name = name;
        this.role = role;
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
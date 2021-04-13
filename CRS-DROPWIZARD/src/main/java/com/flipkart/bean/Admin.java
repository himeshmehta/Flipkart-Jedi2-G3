package com.flipkart.bean;

import com.flipkart.constants.Role;
/**
 * The type Admin
 */
public class Admin extends User {

    /**
     * Constructor of Admin
     * @param name
     * @param email
     * @param role
     * @param userId
     */
    public Admin(String name, String email, Role role, int userId) {
        super(name, email, role,userId);
    }

    /**
     * Constructor of Admin
     * @param user
     */
    public Admin(User user){
        super(user.getName(), user.getEmail(), user.getRole(), user.getUserId());
    }
}

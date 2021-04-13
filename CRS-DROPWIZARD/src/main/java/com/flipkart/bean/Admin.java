package com.flipkart.bean;

import com.flipkart.constants.RoleEnum;
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
            public Admin(String name, String email, RoleEnum roleEnum, int userId) {
                super(name, email, roleEnum,userId);
            }
            /**
             * Constructor of Admin
             * @param user
             */
            public Admin(User user){
                super(user.getName(), user.getEmail(), user.getRole(), user.getUserId());
            }
        }
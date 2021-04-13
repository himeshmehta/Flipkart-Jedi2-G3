package com.flipkart.src.main.java.com.flipkart.bean;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constants.RoleEnum;

import java.util.List;

/**
 * The type professor
 */
public class Professor extends com.flipkart.bean.User {

    private List<com.flipkart.bean.Course> teachingCourses;


    /**
     * Constructor of professor
     * @param name
     * @param email
     * @param role
     * @param userId
     */
    public Professor(String name, String email, RoleEnum roleEnum, int userId) {
        super(name, email, roleEnum, userId);

    }

    /**
     * Constructor of professor
     * @param user
     */
    public Professor(User user){
        super(user.getName(), user.getEmail(), user.getRole(), user.getUserId());
    }

    public Professor(){
        super();
    }
    /**
     * Gets the list of courses taught by professor
     * @return list of courses
     */
    public List<com.flipkart.bean.Course> getTeachingCourses() {
        return teachingCourses;
    }

    /**
     * Sets the list of courses taught by professor
     * @param teachingCourses list of courses
     */
    public void setTeachingCourses(List<Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }
}

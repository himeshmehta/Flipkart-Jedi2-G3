package com.flipkart.bean;

import com.flipkart.constants.RoleEnum;

import java.util.List;

/**
 * The type professor
 */
public class Professor extends User{

    private List<Course> teachingCourses;


    /**
     * Constructor of professor
     * @param name professor name
     * @param email professor email
     * @param roleEnum role
     * @param userId user id
     */
    public Professor(String name, String email, RoleEnum roleEnum, int userId) {
        super(name, email, roleEnum, userId);

    }

    /**
     * Constructor of professor
     * @param user user
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
    public List<Course> getTeachingCourses() {
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

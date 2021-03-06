package com.flipkart.bean;

import com.flipkart.constants.RoleEnum;

import java.util.List;

/**
 * The type student
 */
public class Student extends User{

    private List<Course>mainCourseList;
    private List<String>alternateCourseList;

//    public Student(String name) {
//        super(name);
//    }


    /**
     * Constructor of student
     * @param name
     * @param email
     * @param role
     * @param userId
     */
    public Student(String name, String email, RoleEnum roleEnum, int userId) {
        super(name, email, roleEnum, userId);

    }

    /**
     * Constructor of student
     * @param user
     */
    public Student(User user){
        super(user.getName(), user.getEmail(), user.getRole(), user.getUserId());
    }

    /**
     * Constructor of student
     */
    public Student() {
        super();
    }


    /**
     * Gets the main course List
     * @return main course List
     */
    public List<Course> getMainCourseList() {
        return mainCourseList;
    }

    /**
     * Sets the main course List
     * @param mainCourseList
     */
    public void setMainCourseList(List<Course> mainCourseList) {
        this.mainCourseList = mainCourseList;
    }

    /**
     * Gets the alternate course List
     * @return the alternate course List
     */
    public List<String> getAlternateCourseList() {
        return alternateCourseList;
    }

    /**
     * Sets the alternate course List
     * @param alternateCourseList
     */
    public void setAlternateCourseList(List<String> alternateCourseList) {
        this.alternateCourseList = alternateCourseList;
    }
}
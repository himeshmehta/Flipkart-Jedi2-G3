package com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface CourseDBInterface {

    /**
     * This method is used by student to register for course.
     * @param courseId :- Course object.
     * @param student :- Student object
     * @throws CourseRegistrationException course registration exception
     * @return boolean
     */
    public  Boolean registerStudent(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for revert the registration of course.
     * @param courseId :- Course object.
     * @param student :- Student object.
     * @throws CourseRegistrationException course registration exception
     * @return boolean
     */
    public  Boolean removeStudent(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for viewing course.
     * @throws CourseRegistrationException course registration exception
     * @return List of Courses
     */
    public  List<Course> viewCourses() throws CourseRegistrationException;

    /**
     * This method is used for viewing enrolled course.
     * @param  professor professor
     * @throws CRSException crs exception
     * @return List of Courses
     */
    public List<Course> viewEnrolledCourses(int professor) throws CRSException;
    /**
     * This method is used to get list of registered student for a course.
     * @param course :- Course object.
     * @return list
     */
    public  List<Student> getListOfRegisteredStudents(Course course);

    /**
     * This method is used by the professor to select a course for teaching.
     * @param courseId course id
     * @param professor :- professor object.
     * @throws CRSException crs exception
     * @return boolean
     */
    public  Boolean setProfessor(Integer courseId, Professor professor) throws CRSException;

    /**
     * This method is used to set the availability of course.
     * @param course :- Course object.
     * @return boolean
     */
    public  Boolean setAvailability(Course course);

    /**
     * This method is used to get the details of course.
     * @param courseId :- Course object.
     * @return boolean
     */
    public  Course getCourseDetails(Integer courseId);

    /**
     * This method is used to get the list of student enrolled for a particular course.
     * @param courseId :- id of course.
     * @return list
     * @throws CRSException crs exception
     */

    public  List<Student> getListOfStudents(Integer courseId) throws CRSException;

    /**
     * This method is used to get the list of not paid courses
     * @param studentId student id
     * @return HashMap
     * @throws CRSException course registration exception
     */
    public HashMap<Integer,Integer> getNotpaidCourseList(int studentId) throws CRSException;

    /**
     * This method is used to update the fee paid for courses selected by student
     * @param studentId student id
     * @param selectedCourses selected course
     * @throws CRSException crs exception
     */
    public void setPaidFeeToTRUE(int studentId, Set<Integer> selectedCourses) throws CRSException;

    /**
     * This method is used to get the list of student enrolled for a particular course.
     * @param courseId :- id of course.
     * @param profId :- id of Professor.
     * @throws CRSException crs exception
     * @return boolean.
     */
    public Boolean IsCourseTeachByProf(Integer courseId, int profId) throws CRSException;

    /**
     * This method is used to get the fee of course
     * @param courseIds course id
     * @return int
     * @throws CRSException crs exception
     */
    public int getFee(Set<Integer> courseIds) throws CRSException;

    /**
     * This method is used to add new course in database.
     * @param description description
     * @param courseName course name
     * @param courseFee course fee
     * @throws CRSException crs exception
     * @return Course object
     */
    public Course addNewCourse(String description, String courseName, Long courseFee) throws CRSException;
}

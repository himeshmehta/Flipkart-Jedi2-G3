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
     * @throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean registerStudent(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for revert the registration of course.
     * @param courseId :- Course object.
     * @param student :- Student object.
     * @throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean removeStudent(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for viewing course.
     * @throws CourseRegistrationException
     * @return List of Courses
     */
    public  List<Course> viewCourses() throws CourseRegistrationException;

    /**
     * This method is used for viewing enrolled course.
     * @param  professor
     * @return List of Courses
     */
    public List<Course> viewEnrolledCourses(int professor) throws CRSException;
    /**
     * This method is used to get list of registered student for a course.
     * @param course :- Course object.
     * @throws CourseRegistrationException
     * @return List<Student>: list of student
     */
    public  List<Student> getListOfRegisteredStudents(Course course);

    /**
     * This method is used by the professor to select a course for teaching.
     * @param courseId
     * @param professor :- professor object.
     * @throws CRSException
     * @return Boolean
     */
    public  Boolean setProfessor(Integer courseId, Professor professor) throws CRSException;

    /**
     * This method is used to set the availability of course.
     * @param course :- Course object.
     * @throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean setAvailability(Course course);

    /**
     * This method is used to get the details of course.
     * @param courseId :- Course object.
     * @throws CourseRegistrationException
     * @return Boolean
     */
    public  Course getCourseDetails(Integer courseId);

    /**
     * This method is used to get the list of student enrolled for a particular course.
     * @param courseId :- id of course.
     * @return List<Student> :- List of student registered for this course.
     */

    public  List<Student> getListOfStudents(Integer courseId) throws CRSException;

    /**
     * This method is used to get the list of not paid courses
     * @param studemtId
     * @return HashMap
     * @throws CRSException
     */
    public HashMap<Integer,Integer> getNotpaidCourseList(int studemtId) throws CRSException;

    /**
     * This method is used to update the fee paid for courses selected by student
     * @param studentId
     * @param selectedCourses
     * @throws CRSException
     */
    public void setPaidFeeToTRUE(int studentId, Set<Integer> selectedCourses) throws CRSException;

    /**
     * This method is used to get the list of student enrolled for a particular course.
     * @param courseId :- id of course.
     * @param profId :- id of Professor.
     * @throws CRSException
     * @return Boolean.
     */
    public Boolean IsCourseTeachByProf(Integer courseId, int profId) throws CRSException;

    /**
     * This method is used to get the fee of course
     * @param courseIds
     * @throws CRSException
     */
    public int getFee(Set<Integer> courseIds) throws CRSException;

    /**
     * This method is used to add new course in database.
     * @param description, courseName, courseFee
     * @throws CRSException
     * @return Course object
     */
    public Course addNewCourse(String description, String courseName, Long courseFee) throws CRSException;
}

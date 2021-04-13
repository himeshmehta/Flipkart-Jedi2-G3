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
     * @Param course :- Course object.
     * @Param student :- Student object
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean registerStudent(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for revert the registration of course.
     * @Param course :- Course object.
     * @Param student :- Student object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean removeStudent(User student, Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for viewing course.
     * @Param  Nothing
     * @Throws CourseRegistrationException
     * @return List of Courses
     */
    public  List<Course> viewCourses() throws CourseRegistrationException;

    /**
     * This method is used for viewing enrolled course.
     * @Param  Professor
     * @Throws Nothing
     * @return List of Courses
     */
    public List<Course> viewEnrolledCourses(int professor) throws CRSException;
    /**
     * This method is used to get list of registered student for a course.
     * @Param course :- Course object.
     * @Throws CourseRegistrationException
     * @return List<Student>: list of student
     */
    public  List<Student> getListOfRegisteredStudents(Course course);

    /**
     * This method is used by the professor to select a course for teaching.
     * @Param courseId
     * @Param professor :- professor object.
     * @Throws CRSException
     * @return Boolean
     */
    public  Boolean setProfessor(Integer courseId, Professor professor) throws CRSException;

    /**
     * This method is used to set the availability of course.
     * @Param course :- Course object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean setAvailability(Course course);

    /**
     * This method is used to get the details of course.
     * @Param course :- Course object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Course getCourseDetails(Integer courseID);

    /**
     * This method is used to get the list of student enrolled for a particular course.
     * @Param courseId :- id of course.
     * @Throws Nothing
     * @return List<Student> :- List of student registered for this course.
     */

    public  List<Student> getListOfStudents(Integer courseId) throws CRSException;

    /**
     * This method is used to get the list of not paid courses
     * @param studemtId
     * @return
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
     * @Param courseId :- id of course.
     * @Param profId :- id of Professor.
     * @Throws CRSException
     * @return Boolean.
     */
    public Boolean IsCourseTeachByProf(Integer courseId, int profId) throws CRSException;

    /**
     * This method is used to get the fee of course
     * @param courseIds
     * @return
     * @throws CRSException
     */
    public int getFee(Set<Integer> courseIds) throws CRSException;

    /**
     * This method is used to add new course in database.
     * @Param description, courseName, courseFee
     * @Throws CRSException
     * @return Course object
     */
    public Course addNewCourse(String description, String courseName, Long courseFee) throws CRSException;
}

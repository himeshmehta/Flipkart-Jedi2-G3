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
    public  Boolean registerStudent(User student , Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for revert the registration of course.
     * @Param course :- Course object.
     * @Param student :- Student object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean removeStudent (User student , Integer courseId) throws CourseRegistrationException;

    /**
     * This method is used for viewing course.
     * @Param  Nothing
     * @Throws CourseRegistrationException
     * @return List of Courses
     */
    public  List<Course> viewCourses () throws CourseRegistrationException;

    /**
     * This method is used for viewing enrolled course.
     * @Param  Professor
     * @Throws Nothing
     * @return List of Courses
     */
    public List<Course> viewEnrolledCourses(int professor);
    /**
     * This method is used to get list of registered student for a course.
     * @Param course :- Course object.
     * @Throws CourseRegistrationException
     * @return List<Student>: list of student
     */
    public  List<Student> getListOfRegisteredStudents (Course course);

    /**
     * This method is used to set the professor for teaching.
     * @Param course :- Course object.
     * @Param professor :- professor object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean setProfessor(Integer courseId , Professor professor);

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
     * This method is used to get the list of student.
     * @Param courseId :- id of course.
     * @Throws CourseRegistrationException
     * @return List<Student> :- List of student registered for this course.
     */
    public  List<Student> getListOfStudents(Integer courseId);

    public HashMap<Integer,Integer> getNotpaidCourseList(int studemtId) throws CRSException;

    public void setPaidFeeToTRUE(int studentId, Set<Integer> selectedCourses) throws CRSException;

    Boolean IsCourseTeachByProf(Integer courseId, int profId) throws CRSException;

    int getFee(Set<Integer> courseIds) throws CRSException;
}

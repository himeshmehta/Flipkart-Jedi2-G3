package com.flipkart.dao;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface CourseDBInterface {

    /**
     * This method is used by student to register for course.
     * @Param course :- Course object.
     * @Param student :- Student object
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean registerStudent(Student student , Course course) throws CourseRegistrationException;

    /**
     * This method is used for revert the registration of course.
     * @Param course :- Course object.
     * @Param student :- Student object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean removeStudent (Student student , Course course) throws CourseRegistrationException;

    /**
     * This method is used for adding a student to course.
     * @Param course :- Course object.
     * @Param student :- Student object.
     * @Throws CourseRegistrationException
     * @return Boolean
     */
    public  Boolean addStudent (Student student , Course course) throws CourseRegistrationException;

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
    public  Boolean setProfessor(Course course , Professor professor);

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
    public  Course getCourseDetails(String courseID);

    /**
     * This method is used to get the list of student.
     * @Param courseId :- id of course.
     * @Throws CourseRegistrationException
     * @return List<Student> :- List of student registered for this course.
     */
    public  List<Student> getListOfStudents(String courseId);
}
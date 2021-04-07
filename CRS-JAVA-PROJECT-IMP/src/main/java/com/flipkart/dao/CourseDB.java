package com.flipkart.dao;

import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDB implements CourseDBInterface{
    private Connection conn = null;
    private PreparedStatement sqlQuery;
    public CourseDB() {
        conn = DBUtil.getConnection();
        sqlQuery = null;
    }
    public  Boolean registerStudent(Student student , Integer courseId) throws CourseRegistrationException {
        throw new CourseRegistrationException("Unable to register");
    }

    public  Boolean removeStudent (Student student , Integer courseId){
        try{
            // add details in student table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.DROP_COURSE_FOR_STUDENT);
            sqlQuery.setInt(1,courseId);
            sqlQuery.setInt(2,student.getUserId());

            sqlQuery.executeUpdate();
            sqlQuery.close();

            return Boolean.TRUE;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public  Boolean addStudent (Student student , Integer courseId){
        return Boolean.TRUE;
    }

    public  List<Student> getListOfRegisteredStudents (Course course) {
        return new ArrayList<>();
    }

    public  Boolean setProfessor(Course course , Professor professor) {
        return Boolean.TRUE;
    }

    public  Boolean setAvailability(Course course) {
        return Boolean.TRUE;
    }

    public  Course getCourseDetails(Integer courseID){
        return null;
    }

    public List<Student> getListOfStudents(Integer courseId) {
        List<Student> studentList = new ArrayList<Student>();

        return studentList;
    }
}
package com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CourseDB implements CourseDBInterface{
    private Connection conn = null;
    private PreparedStatement sqlQuery;
    public CourseDB() {
        conn = DBUtil.getConnection();
        sqlQuery = null;
    }
    public  Boolean registerStudent(Student student , Integer courseId) throws CourseRegistrationException {
        try {
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_COURSE_DETAILS);
            sqlQuery.setInt(1,courseId);

            ResultSet resultSet = sqlQuery.executeQuery();
            if (resultSet.next()) {
                sqlQuery = conn.prepareStatement(SQLQueriesConstants.REGISTER_STUDENT_FOR_COURSE);
                sqlQuery.setInt(1,courseId);
                sqlQuery.setInt(2,student.getUserId());
                sqlQuery.executeUpdate();
                sqlQuery.close();
                return Boolean.TRUE;
            } else throw new CourseRegistrationException("Unable to register");

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return Boolean.FALSE;
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

    public  List<Course> viewCourses (){
        List<Course> courseList = new ArrayList<>();
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_COURSE_TABLE);
            ResultSet resultSet = sqlQuery.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("courseId"));
                course.setCourseName(resultSet.getString("coursename"));
                course.setProfessorId(resultSet.getInt("userId") == 0? -1 : resultSet.getInt("userId"));
                course.setFee(resultSet.getLong("fee"));
                courseList.add(course);
            }
            sqlQuery.close();
            return courseList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return courseList;
    }

    public List<Course> viewEnrolledCourses(int professorId) {
        List<Course> courseList = new ArrayList<>();
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_PROFESSOR_COURSES);
            sqlQuery.setInt(1,professorId);
            ResultSet resultSet = sqlQuery.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseId(resultSet.getInt("courseId"));
                course.setCourseName(resultSet.getString("coursename"));
                course.setProfessorId(resultSet.getInt("userId"));
                course.setFee(resultSet.getLong("fee"));
                courseList.add(course);
            }
            sqlQuery.close();
            return courseList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return courseList;
    }

    public  List<Student> getListOfRegisteredStudents (Course course) {
        return new ArrayList<>();
    }

    public  Boolean setProfessor(Integer courseId , Professor professor) {
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_COURSE_PROFESSOR);
            sqlQuery.setInt(1,courseId);
            ResultSet resultSet = sqlQuery.executeQuery();
            if (!resultSet.next() || resultSet.getInt("userId") != 0) throw new SQLException("Professor already added");
            else {
                sqlQuery = conn.prepareStatement(SQLQueriesConstants.SET_PROFESSOR);
                sqlQuery.setInt(1,professor.getUserId());
                sqlQuery.setInt(2,courseId);
                sqlQuery.executeUpdate();
            }
            sqlQuery.close();
            return Boolean.TRUE;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return Boolean.FALSE;
    }

    public  Boolean setAvailability(Course course) {
        return Boolean.TRUE;
    }

    public  Course getCourseDetails(Integer courseID){
        return null;
    }

    public List<Student> getListOfStudents(Integer courseId) {
        List<Student> studentList = new ArrayList<Student>();
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_STUDENT_FOR_COURSE);
            sqlQuery.setInt(1,courseId);
            ResultSet resultSet = sqlQuery.executeQuery();
            while (resultSet.next()) {
                sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_USER_DETAIL);
                sqlQuery.setInt(1,resultSet.getInt("studentId"));
                ResultSet rs = sqlQuery.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    int studentId = rs.getInt("userId");
                    Student student = new Student();
                    student.setName(name);
                    student.setUserId(studentId);
                    studentList.add(student);
                }
            }
            return studentList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return studentList;
    }

    @Override
    public HashMap<Integer, Integer> getNotpaidCourseList(int studentId) throws CRSException {
        HashMap<Integer,Integer> courseToFeeMap = new HashMap<>();
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_NOT_PAID_COURSES);
            sqlQuery.setInt(1,studentId);
            ResultSet rs = sqlQuery.executeQuery();
            Integer courseId, fee;
            while(rs.next()){
                courseId = rs.getInt("courseId");
                fee = rs.getInt("fee");
                courseToFeeMap.put(courseId,fee);
            }
            sqlQuery.close();
        } catch (SQLException ex) {
            throw new CRSException(ex.getMessage());
        }
        return courseToFeeMap;
    }

    @Override
    public void setPaidFeeToTRUE(int studentId, Set<Integer> selectedCourses) throws CRSException {
        try{
            for(Integer courseId : selectedCourses){
                sqlQuery = conn.prepareStatement(SQLQueriesConstants.PAID_FEE);
                sqlQuery.setInt(1,studentId);
                sqlQuery.setInt(2,courseId);
                sqlQuery.executeUpdate();
            }
            sqlQuery.close();
        } catch (SQLException ex) {
            throw new CRSException(ex.getMessage());
        }
    }

    @Override
    public Boolean IsCourseTeachByProf(Integer courseId, int profId) throws CRSException {
        try {
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.IS_PROF_TEACHING_COURSE);
            sqlQuery.setInt(1,courseId);
            sqlQuery.setInt(2,profId);

            ResultSet rs = sqlQuery.executeQuery();
            if(rs.next()) return Boolean.TRUE;
            else{
                throw new InvalidDataException("You are not assign to course "  + courseId);
            }
        } catch (SQLException | InvalidDataException ex) {
            throw new CRSException(ex.getMessage());
        }
    }
}
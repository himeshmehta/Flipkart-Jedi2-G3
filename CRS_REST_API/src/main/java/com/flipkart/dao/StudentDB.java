package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDB implements StudentDBInterface{
    private Connection conn = null;
    private PreparedStatement sqlQuery;
    public StudentDB() {
        conn = DBUtil.getConnection();
        sqlQuery = null;
    }
    public List<Course> registeredCourses(Student student) {
        List<Course> courseList = new ArrayList<>();
        try{
            // add details in student table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_COURSE_FOR_STUDENT);
            sqlQuery.setInt(1,student.getUserId());

            ResultSet rs = sqlQuery.executeQuery();
//            rs.next();
            while (rs.next()) {
                try {
                    sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_COURSE_DETAILS);
                    Course course = new Course();
                    int courseId = rs.getInt(1);
                    sqlQuery.setInt(1,courseId);
                    ResultSet resultSet = sqlQuery.executeQuery();
                    while (resultSet.next()) {
                        course.setCourseId(courseId);
                        course.setCourseName(resultSet.getString("coursename"));
                        course.setProfessorId(resultSet.getInt("userId"));
                        course.setFee(resultSet.getLong("fee"));
                    }
                    courseList.add(course);
                    sqlQuery.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            return courseList;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return courseList;
    }
}

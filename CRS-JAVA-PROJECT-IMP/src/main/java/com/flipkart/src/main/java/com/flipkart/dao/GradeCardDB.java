package com.flipkart.src.main.java.com.flipkart.dao;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.GradeCard;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.dao.GradeCardDBInterface;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GradeCardDB implements GradeCardDBInterface {

    private Connection conn ;
    private PreparedStatement sqlQuery;

    public GradeCardDB(){
        this.conn = DBUtil.getConnection();
        sqlQuery = null;
    }

    @Override
    public  GradeCard viewGradeCard(Integer studentId) throws GradeCardNotFoundException {
        GradeCard gradeCard = null;
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.FETCH_GRADE_CARD);
            sqlQuery.setInt(1,studentId);
            sqlQuery.executeQuery();
            ResultSet rs = sqlQuery.executeQuery();
            Map<Integer,Integer> courseMarks = new HashMap<Integer, Integer>();
            while(rs.next()){
                courseMarks.put(rs.getInt("courseId"), rs.getInt("grade"));
            }
            gradeCard = new GradeCard(courseMarks);
            gradeCard.getStudentDetails().setUserId(studentId);

            return gradeCard;
        } catch (SQLException ex) {
            throw new GradeCardNotFoundException(ex.getMessage());
        }
    }

    @Override
    public  void addGrade(Integer courseId, Integer grade,Integer studentId) throws CRSException {
        try{
            // first check if grade is already added or not.
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.FETCH_INDIVIDUAL_COURSE_GRADE);
            sqlQuery.setInt(1,studentId);
            sqlQuery.setInt(2,courseId);
            ResultSet rs = sqlQuery.executeQuery();

            if(rs.next()){
                // grade already added, now update grade
                sqlQuery = conn.prepareStatement(SQLQueriesConstants.UPDATE_GRADES);
                sqlQuery.setInt(1,grade);
                sqlQuery.setInt(2,studentId);
                sqlQuery.setInt(3,courseId);
            }else{
                // add grade
                sqlQuery = conn.prepareStatement(SQLQueriesConstants.ADD_GRADES);
                sqlQuery.setInt(1,studentId);
                sqlQuery.setInt(2,courseId);
                sqlQuery.setInt(3,grade);
            }

            sqlQuery.executeUpdate();
            sqlQuery.close();
        } catch (SQLException ex) {
            throw new CRSException(ex.getMessage());
        }
    }
}

package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDB implements AuthDBInterface{

    private Connection conn = null;
    private PreparedStatement sqlQuery;
    public AuthDB(){
        conn = DBUtil.getConnection();
        sqlQuery = null;
    }

    public User AuthenticateUser(int userId, String password) throws AuthorizationException {
        User user = new User();
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.AUTHORISE_USER);

            sqlQuery.setInt(1,userId);
            ResultSet rs = sqlQuery.executeQuery();

            if(!rs.next()){
                throw new AuthorizationException("user id does not exists.");
            }
            else
            {
                // set user data
                Boolean isApproved = rs.getBoolean("isApproved");
                String passInDB = rs.getString("password");

                System.out.println(1);
                if(isApproved == false){
                    throw new AuthorizationException("Your are not approved yet.");
                }
                if(!passInDB.equals(password)){
                    throw new AuthorizationException("Incorrect password.");
                }
                // System.out.println(rs.getInt("userId"));
                user.setUserId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                String role = rs.getString("role");
                System.out.println(role + " in DB ");
                switch (role){
                    case "Student":
                        user.setRole(Role.STUDENT);
                    case "Admin":
                        user.setRole(Role.ADMIN);
                        break;
                    case "Professor":
                        user.setRole(Role.PROFESSOR);
                }
            }

        } catch (SQLException ex) {
            user = null;
            throw new AuthorizationException(ex.getMessage());
        }
        return user;
    }

    public  Boolean addNewUser(User user,String password){
        return Boolean.TRUE;
    }

    public  Boolean removeExistingUser(User user){
        return Boolean.TRUE;
    }

    public  Boolean approveStudent(String studentId){
        return Boolean.TRUE;
    }

    @Override
    public Boolean selfRegisterStudent(String email, String name, String password) {
        Boolean isRegistered = Boolean.FALSE;
        try{
            // add details in student table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.SELF_REGISTER_QUERY);
            sqlQuery.setString(1,email);
            sqlQuery.setString(2,name);
            sqlQuery.setString(3,password);
            sqlQuery.setBoolean(4,Boolean.FALSE);
            sqlQuery.setString(5,"Student");

            sqlQuery.executeUpdate();
            sqlQuery.close();

            // add details in student table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
            sqlQuery.setString(1,email);
            sqlQuery.setString(2,name);
            sqlQuery.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return isRegistered;
    }


}

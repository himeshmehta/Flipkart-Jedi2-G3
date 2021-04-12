package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.client.AdminDashboard;
import com.flipkart.constants.Role;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AuthDB implements AuthDBInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(AdminDashboard.class));
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

                switch (role){
                    case "Student":
                        user.setRole(Role.STUDENT);
                        break;
                    case "Admin":
                        user.setRole(Role.ADMIN);
                        break;
                    case "Professor":
                        user.setRole(Role.PROFESSOR);
                        break;
                }
            }

        } catch (SQLException ex) {
            user = null;
            throw new AuthorizationException(ex.getMessage());
        }
        return user;
    }

    public  User addNewUser(User user,String password) throws CRSException {
        User newUser = null;
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.ADD_USER_QUERY,Statement.RETURN_GENERATED_KEYS);
            sqlQuery.setString(1,user.getEmail());
            sqlQuery.setString(2,user.getName());
            sqlQuery.setString(3,password);
            sqlQuery.setBoolean(4,true);
            sqlQuery.setInt(5, getIndexFromRole(user.getRole()));
            sqlQuery.executeUpdate();

            newUser = new User();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setRole(user.getRole());

            ResultSet rs = sqlQuery.getGeneratedKeys();
            if(rs.next()){
                newUser.setUserId(rs.getInt(1));
            }

            sqlQuery.close();

            // now add user in respective database
            sqlQuery = conn.prepareStatement(getAddIndividual(user.getRole()));
            sqlQuery.setString(1,user.getEmail());
            sqlQuery.setString(2,user.getName());
            sqlQuery.executeUpdate();
            sqlQuery.close();

        } catch (SQLException e) {
            newUser = null;
            throw new CRSException(e.getMessage());
        }
        return newUser;
    }

    private Integer getIndexFromRole(Role role) {
        Integer index = 0;
        switch (role){
            case STUDENT:
                index = 1;
                break;
            case ADMIN:
                index = 2;
                break;
            case PROFESSOR:
                index = 3;
                break;
        }
        return index;
    }

    private String getAddIndividual(Role role) {
        String query = null;
        switch(role){
            case ADMIN:
                query =  SQLQueriesConstants.ADD_ADMIN;
                break;
            case STUDENT:
                query =  SQLQueriesConstants.ADD_STUDENT;
                break;
            case PROFESSOR:
                query =  SQLQueriesConstants.ADD_PROFESSOR;
                break;
        }
        return query;
    }

    @Override
    public void removeExistingUser(int userId) throws CRSException {
        try {
            User user = getUserDetails(userId);

            // first remove from respective table
            sqlQuery = conn.prepareStatement(getRemoveQueryFromRole(user.getRole()));
            sqlQuery.setString(1,user.getEmail());
            sqlQuery.executeUpdate();
            sqlQuery.close();

            // now remove from user table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.DELETE_USER_QUERY);
            sqlQuery.setInt(1,user.getUserId());
            sqlQuery.executeUpdate();
            sqlQuery.close();
        } catch (SQLException | InvalidDataException | CRSException ex) {
            throw new CRSException(ex.getMessage());
        }
    }

    private String getRemoveQueryFromRole(Role role) {
        String removeUser = null;
        switch(role){
            case ADMIN:
                removeUser =  SQLQueriesConstants.DELETE_ADMIN;
                break;
            case STUDENT:
                removeUser =  SQLQueriesConstants.DELETE_STUDENT;
                break;
            case PROFESSOR:
                removeUser =  SQLQueriesConstants.DELETE_PROFESSOR;
                break;
        }
        return removeUser;
    }

    @Override
    public void approveStudent(int studentId) throws CRSException {
        try {
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT);
            sqlQuery.setInt(1,studentId);
            sqlQuery.executeUpdate();
            sqlQuery.close();
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
            throw new CRSException(ex.getMessage());
        }
    }


    @Override
    public User selfRegisterStudent(String email, String name, String password) {
        User user  = null;
        try{
            // add details in student table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.SELF_REGISTER_QUERY, Statement.RETURN_GENERATED_KEYS);
            sqlQuery.setString(1,email);
            sqlQuery.setString(2,name);
            sqlQuery.setString(3,password);
            sqlQuery.setBoolean(4,Boolean.FALSE);
            sqlQuery.setString(5,"Student");

            sqlQuery.executeUpdate();

            // create a user object to return
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setRole(Role.STUDENT);

            ResultSet rs = sqlQuery.getGeneratedKeys();
            while(rs.next()){
                System.out.println(rs.getInt(1));
                user.setUserId(rs.getInt(1));
            }
            sqlQuery.close();

            // add details in student table
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.ADD_STUDENT);
            sqlQuery.setString(1,email);
            sqlQuery.setString(2,name);
            sqlQuery.executeUpdate();
            return user;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUserDetails(int userId) throws InvalidDataException, CRSException {
        User user = null;
        try {
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_USER_DETAILS);
            sqlQuery.setInt(1,userId);
            ResultSet rs = sqlQuery.executeQuery();
            if(!rs.next()){
                throw new InvalidDataException( String.valueOf(userId)+ " does not exists.");
            }
            String email = rs.getString("email");
            String name = rs.getString("name");
            String roleFromDB = rs.getString("role");
            user = new User(name,email,getRoleFromText(roleFromDB),userId);
            sqlQuery.close();
        } catch (SQLException ex) {
            throw new CRSException(ex.getMessage());
        }
        return user;
    }


    private Role getRoleFromText(String roleFromDB) {
        Role role = null;
        switch (roleFromDB) {
            case "Student":
                role = Role.STUDENT;
                break;
            case "Admin":
                role = Role.ADMIN;
                break;
            case "Professor":
                role = Role.PROFESSOR;
                break;
        }
        return role;
    }

    private Role getRoleFromIndex(int roleIndex) {
        Role role = null;
        switch (roleIndex) {
            case 1:
                role = Role.STUDENT;
                break;
            case 2:
                role = Role.ADMIN;
                break;
            case 3:
                role = Role.PROFESSOR;
                break;
        }
        return role;
    }


    public List<Integer> getNotApprovedStudent() throws CRSException {
        List<Integer> result = new ArrayList<>();
        try{
            System.out.println("in auth DB");
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.NOT_APPROVED_QUERY);
            // sqlQuery.setString(1,"Student");
            ResultSet rs = sqlQuery.executeQuery();

            while(rs.next()){
                result.add(rs.getInt("userId"));
            }

            sqlQuery.close();
        } catch (SQLException e) {
            logger.info(e.getMessage());
            throw new CRSException(e.getMessage());
        }
        return result;
    }
}

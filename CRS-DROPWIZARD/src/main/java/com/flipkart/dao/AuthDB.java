package com.flipkart.dao;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.User;
import com.flipkart.constants.RoleEnum;
import com.flipkart.dashboard.AdminDashboard;
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
                // if result set does not have any row
                throw new AuthorizationException("user id does not exists.");
            }
            else
            {
                // set user data
                Boolean isApproved = rs.getBoolean("isApproved");
                String passInDB = rs.getString("password");

                if(!isApproved){
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
                        user.setRole(RoleEnum.STUDENT);
                        break;
                    case "Admin":
                        user.setRole(RoleEnum.ADMIN);
                        break;
                    case "Professor":
                        user.setRole(RoleEnum.PROFESSOR);
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
            sqlQuery.setBoolean(4,true); // setting isApproved state to true, because admin is adding this user
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

    /**
     * This methode is used to get index from RoleEnum enum to store roleEnum in database.
     * @Param roleEnum : RoleEnum enum.
     * @Throws Nothing
     * @Return Integer : index for roles.
     * */
    private Integer getIndexFromRole(RoleEnum roleEnum) {
        Integer index = 0;
        switch (roleEnum){
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

    /**
     * This methode is used to get sql query for adding information in individual table based on roleEnum of user.
     * @Param roleEnum : RoleEnum enum.
     * @Throws Nothing
     * @Return String : sql query to add row in table.
     * */
    private String getAddIndividual(RoleEnum roleEnum) {
        String query = null;
        switch(roleEnum){
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
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_USER_DETAILS);
            sqlQuery.setInt(1,user.getUserId());
            ResultSet rs = sqlQuery.executeQuery();
            if (!rs.next()) throw new CRSException("User does not Exist");
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.DELETE_USER_QUERY);
            sqlQuery.setInt(1,user.getUserId());
            sqlQuery.executeUpdate();
            sqlQuery.close();
        } catch (SQLException | InvalidDataException | CRSException ex) {
            throw new CRSException(ex.getMessage());
        }
    }

    /**
     * This methode is used to get sql query for removing information from individual table based on roleEnum of user.
     * @Param roleEnum : RoleEnum enum.
     * @Throws Nothing
     * @Return String : sql query to remove row in table.
     * */
    private String getRemoveQueryFromRole(RoleEnum roleEnum) {
        String removeUser = null;
        switch(roleEnum){
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
    public User selfRegisterStudent(String email, String name, String password) throws CRSException {
        User user  = null;
        try{
            // verifying if user already exist

            sqlQuery = conn.prepareStatement(SQLQueriesConstants.GET_USER_DATA);
            sqlQuery.setString(1,email);
            ResultSet rs = sqlQuery.executeQuery();
            if (rs.next()) throw new CRSException("User already Exists");

            // add details in student table

            sqlQuery = conn.prepareStatement(SQLQueriesConstants.SELF_REGISTER_QUERY, Statement.RETURN_GENERATED_KEYS);
            sqlQuery.setString(1,email);
            sqlQuery.setString(2,name);
            sqlQuery.setString(3,password);
            sqlQuery.setBoolean(4,Boolean.FALSE);
            sqlQuery.setString(5,"Student"); // only student can self register

            sqlQuery.executeUpdate();

            // create a user object to return
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setRole(RoleEnum.STUDENT);

            rs = sqlQuery.getGeneratedKeys();
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
        } catch (SQLException ex) {
            throw new CRSException(ex.getMessage());
        }

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

    /**
     * This method is used to get RoleEnum enum from text
     * @Param roleFromDB : string return from database
     * @Throws Nothing
     * @Return RoleEnum
     * */
    private RoleEnum getRoleFromText(String roleFromDB) {
        RoleEnum roleEnum = null;
        switch (roleFromDB) {
            case "Student":
                roleEnum = RoleEnum.STUDENT;
                break;
            case "Admin":
                roleEnum = RoleEnum.ADMIN;
                break;
            case "Professor":
                roleEnum = RoleEnum.PROFESSOR;
                break;
        }
        return roleEnum;
    }

    @Override
    public List<Integer> getNotApprovedStudent() throws CRSException {
        List<Integer> result = new ArrayList<>();
        try{
            sqlQuery = conn.prepareStatement(SQLQueriesConstants.NOT_APPROVED_QUERY);
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

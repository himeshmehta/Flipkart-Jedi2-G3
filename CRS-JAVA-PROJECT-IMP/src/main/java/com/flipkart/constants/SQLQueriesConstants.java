package com.flipkart.constants;

public class SQLQueriesConstants {

    // Course Catalog Queries
    public static final String VIEW_ALL_COURSES = "select courseid, coursename,  description from coursecatalog";
    public static final String GET_COURSE = "select * from coursecatalog where courseid = ?";

    // Student related Queries

    public static final String GET_STUDENT_DETAILS = "select * from student where id = ? ";
    public static final String GET_COURSE_COUNT_FOR_STUDENT = "select count(*) as c from registeredcourses where studentid = ?";
    public static final String GET_STUDENT_COUNT_FOR_COURSE = "select count(*) as c from registeredcourses where courseid = ?";
    public static final String REGISTER_STUDENT_FOR_COURSE = "insert into registeredcourses(courseid, studentid) values (?,?)";
    public static final String GET_COURSE_FOR_STUDENT = "select courseid from registeredcourses where studentid = ?";
    public static final String DROP_COURSE_FOR_STUDENT = "delete from registeredcourses where courseid = ? and studentid = ?";
    public static final String MAKE_PAYMENT_QUERY = "insert into payments (studentid, feespaid, paymentdate, paymentmethod) values(?, ?, ?, ?)";

    // Professor related Queries
    public static final String GET_PROFESSOR_DETAILS = "select * from professor where id = ?";
    public static final String GRADE_STUDENT = "update registeredcourses set grade = ? where studentid = ? and courseid = ?";



    // Admin related Queries
    public static final String ADD_USER_QUERY="insert into user(name,email,role) values(?,?,?)";
    public static final String DELETE_USER_QUERY = "delete from user where userid = ?";


    // User related Queries
    public static final String LOGIN_USER_QUERY = "select role from user where username = ? and password = ?";
    public static final String VERIFY_USERNAME_AND_USERID = "select count(*) as c from user where username = ? OR userid = ?";
    public static final String GET_USER_DETAILS = "select userid from user where username = ?";





}

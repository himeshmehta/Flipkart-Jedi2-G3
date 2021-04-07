package com.flipkart.constants;

public class SQLQueriesConstants {

    // for Courses
    public static final String GET_COURSE_DETAILS = "select * from course where courseId = ?";
    public static final String GET_COURSE_TABLE = "select * from course";
    public static final String GET_COURSE_PROFESSOR = "select userId from course where courseId = ?";
    public static final String SET_PROFESSOR = "update course set userId = ? where courseId = ?";

    // Course Catalog Queries
    public static final String VIEW_ALL_COURSES = "select courseid, coursename,  description from coursecatalog";
    public static final String GET_COURSE = "select * from coursecatalog where courseid = ?";
    public static final String ADD_NEW_COURSE = "insert into course(courseName,description,fee) values(?,?,?)";

    // Student related Queries
    public static final String GET_STUDENT_DETAILS = "select * from student where id = ? ";
    public static final String GET_COURSE_COUNT_FOR_STUDENT = "select count(*) as c from registeredcourses where studentid = ?";
    public static final String GET_STUDENT_COUNT_FOR_COURSE = "select count(*) as c from registeredcourses where courseid = ?";
    public static final String REGISTER_STUDENT_FOR_COURSE = "insert into registeredcourses(courseid, studentid) values (?,?)";
    public static final String GET_COURSE_FOR_STUDENT = "select courseId from registeredcourses where studentId = ?";
    public static final String DROP_COURSE_FOR_STUDENT = "delete from registeredcourses where courseid = ? and studentid = ?";
    public static final String MAKE_PAYMENT_QUERY = "insert into payments (studentid, feespaid, paymentdate, paymentmethod) values(?, ?, ?, ?)";
    public static final String SELF_REGISTER_QUERY = "insert into user (email, name, password, isApproved, role) values(?,?,?,?,?)";

    // Professor related Queries
    public static final String GET_PROFESSOR_DETAILS = "select * from professor where id = ?";
    public static final String GRADE_STUDENT = "update registeredcourses set grade = ? where studentid = ? and courseid = ?";
    public static final String GET_PROFESSOR_COURSES = "select * from course where userId = ?";


    // Admin related Queries
    public static final String ADD_USER_QUERY="insert into user(email,name,password,isApproved,role) values(?,?,?,?,?)";
    public static final String DELETE_USER_QUERY = "delete from user where userid = ?";
    public static final String NOT_APPROVED_QUERY = "select userId from user where role = 1 and isApproved = 0;";
    public static final String ADD_ADMIN = "insert into admin(email,name) values(?,?)";
    public static final String APPROVE_STUDENT = "update user set isApproved = 1 where userId = ?";
    public static final String DELETE_ADMIN = "delete from admin where email = ?";

    // User related Queries
    public static final String LOGIN_USER_QUERY = "select role from user where username = ? and password = ?";
    public static final String VERIFY_USERNAME_AND_USERID = "select count(*) as c from user where username = ? OR userid = ?";
    public static final String GET_USER_DETAILS = "select email,name,role from user where userId = ?";

    // Student table Query
    public static final String ADD_STUDENT = "insert into student (email,name) values(?,?)";
    public static final String DELETE_STUDENT = "delete from student where email = ?";

    // Professor table Query
    public static final String ADD_PROFESSOR = "insert into professor (email,name) values(?,?)";
    public static final String DELETE_PROFESSOR = "delete from professor where email = ?";

    // Authenticate Query
    public static final String AUTHORISE_USER = "select * from user where userId = ?";

    // Notification table query
    public static String SEND_NOTIFICATION = "insert into notification (description, receiverId, time) values(?,?,?)";

}

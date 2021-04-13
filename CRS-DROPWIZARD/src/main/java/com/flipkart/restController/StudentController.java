package com.flipkart.restController;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.dao.StudentDB;
import com.flipkart.requestPojo.PaymentRequest;
import com.flipkart.requestPojo.StudentCourseRequest;
import com.flipkart.services.CourseRegistrationServices;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.PaymentServices;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type student controller
 */
@Path("/student")
public class StudentController {

    private static CourseRegistrationServices courseRegistrationServices  = new CourseRegistrationServices();
    private static StudentDB studentDB = new StudentDB();
    private static GradeCardServices gradeCardServices = new GradeCardServices();
    private static PaymentServices paymentServices = new PaymentServices();

    private final Validator validator;

    public StudentController(Validator validator) {
        this.validator = validator;
    }

    /**
     * Gets the list of all courses
     * @return
     * @throws CourseRegistrationException
     */
    @GET
    @Path("/viewAllCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllCourses() throws CourseRegistrationException {
        try {
            System.out.println("In professor");
            List<Course> courses = new ArrayList<>();
            courses = courseRegistrationServices.viewCourses();
            return Response.status(200).entity(courses).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }


    /**
     * Gets the list of enrolled courses
     * @param studentId
     * @return
     */
    @GET
    @Path("/viewEnrolledCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledCourses(@PathParam("studentId") int studentId) {
        try {
            List<Course> courses = new ArrayList<>();
            Student student = new Student();
            student.setUserId(studentId);
            courses = studentDB.registeredCourses(student);
            return Response.status(200).entity(courses).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }

    /**
     * Gets the grade card of student
     * @param studentId
     * @return
     * @throws GradeCardNotFoundException
     */
    @GET
    @Path("/gradeCard/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGradeCard(@PathParam("studentId") int studentId) throws GradeCardNotFoundException {
        try {
            GradeCard gradeCard = gradeCardServices.viewGradeCard(studentId);
            return Response.status(200).entity(gradeCard).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }

    /**
     * Gets the list of courses for which payment is not done
     * @param studentId
     * @return
     * @throws CRSException
     */
    @GET
    @Path("/feeRemaining/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewNotPaidCourses(@PathParam("studentId") int studentId) throws CRSException {
        try {
            HashMap<Integer,Integer> courseToFee = courseRegistrationServices.getNotPaidCourseList(studentId);
            return Response.status(200).entity(courseToFee).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }

    /**
     * Register for course
     * @param request
     * @return
     */
    @POST
    @Path("/registerCourse")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public Response registerCourse(StudentCourseRequest request){
        try {
            courseRegistrationServices.registerCourse(request.getStudent(), request.getCourseId());
        } catch (Exception ex) {
            return Response.status(500).entity( "Course Registration Failed, Please Try Again ! ").build();
        }
        return Response.status(200).entity( "Registration Successful").build();
    }

    /**
     * Remove course
     * @param request
     * @return
     */
    @DELETE
    @Path("/removeCourse")
    @Consumes("application/json")
    public Response removeCourse(StudentCourseRequest request) {
        try {
            courseRegistrationServices.removeCourse(request.getStudent(), request.getCourseId());
        } catch (Exception ex) {
            return Response.status(500).entity( "Course Removal Failed, Please Try Again ! ").build();
        }
        return Response.status(200).entity("Removal Successful").build();
    }

    /**
     * Pay fee for selected courses
     * @param request
     * @return
     * @throws CRSException
     */
    @PUT
    @Path("/payFee")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response completePayment(PaymentRequest request) throws CRSException {
        try {
            String message  = paymentServices.completePayment(request);
            return Response.status(200).entity(message).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Payment Failed, Please Try Again ! ").build();
        }
    }

}

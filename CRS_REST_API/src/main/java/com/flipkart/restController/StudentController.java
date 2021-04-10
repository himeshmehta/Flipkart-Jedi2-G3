package com.flipkart.restController;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.GradeCardNotFoundException;
import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDB;
import com.flipkart.requestPojo.PaymentRequest;
import com.flipkart.services.CourseRegistrationServices;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.PaymentServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/student")
public class StudentController {

    private static CourseRegistrationServices courseRegistrationServices  = new CourseRegistrationServices();
    private static StudentDB studentDB = new StudentDB();
    private static GradeCardServices gradeCardServices = new GradeCardServices();
    private static PaymentServices paymentServices = new PaymentServices();
    @GET
    @Path("/viewAllCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllCourses() throws CourseRegistrationException {
        System.out.println("In professor");
        List<Course> courses = new ArrayList<>();
        courses = courseRegistrationServices.viewCourses();
        return Response.status(200).entity(courses).build();
    }


    @GET
    @Path("/viewEnrolledCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledCourses(@PathParam("studentId") int studentId) {
        List<Course> courses = new ArrayList<>();
        Student student = new Student();
        student.setUserId(studentId);
        courses = studentDB.registeredCourses(student);
        return Response.status(200).entity(courses).build();
    }

    @GET
    @Path("/gradeCard/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGradeCard(@PathParam("studentId") int studentId) throws GradeCardNotFoundException {
        GradeCard gradeCard = gradeCardServices.viewGradeCard(studentId);
        return Response.status(200).entity(gradeCard).build();
    }

    @GET
    @Path("/feeRemaining/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewNotPaidCourses(@PathParam("studentId") int studentId) throws CRSException {
        HashMap<Integer,Integer> courseToFee = courseRegistrationServices.getNotPaidCourseList(studentId);
        return Response.status(200).entity(courseToFee).build();
    }

    @PUT
    @Path("/payFee")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response completePayment(PaymentRequest request) throws CRSException {
        String message  = paymentServices.completePayment(request);
        return Response.status(200).entity(message).build();
    }

}

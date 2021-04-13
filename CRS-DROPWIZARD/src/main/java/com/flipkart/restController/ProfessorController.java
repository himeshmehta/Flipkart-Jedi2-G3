package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;
import com.flipkart.requestPojo.AddGradeRequest;
import com.flipkart.requestPojo.SelectCourseToTeachRequest;
import com.flipkart.services.GradeCardServices;
import com.flipkart.services.ProfessorServices;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/professor")
public class ProfessorController {

    private static ProfessorServices professorServices = new ProfessorServices(new CourseDB());
    private static GradeCardServices gradeCardServices = new GradeCardServices();

    private final Validator validator;

    public ProfessorController(Validator validator) {
        this.validator = validator;
    }

    @GET
    @Path("/viewAllCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllCourses() {
        System.out.println("In professor");
        List<Course> courses = new ArrayList<>();
        courses = professorServices.viewCourses();
        return Response.status(200).entity(courses).build();
    }

    @GET
    @Path("/viewEnrolledStudents/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledStudents(@PathParam("courseId") int courseId){
        List<Student> studentList = professorServices.getEnrolledStudents(courseId);
        return Response.status(200).entity(studentList).build();
    }

    @GET
    @Path("/viewSelectedCourses/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewSelectedCourses(@PathParam("professorId") int professorId) {
        System.out.println("In professor");
        List<Course> courses = new ArrayList<>();
        courses = professorServices.viewEnrolledCourses(professorId);
        return Response.status(200).entity(courses).build();
    }

    @POST
    @Path("/selectCourseToTeach")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public Response SelectCourseToTeach(SelectCourseToTeachRequest request){
        try {
            professorServices.selectCourseToTeach(request.getCourseId(),request.getProfessor());
        } catch (Exception ex) {
            return Response.status(500).entity( "Course Registration Failed. Reason :- " + ex.getMessage()).build();
        }
        return Response.status(200).entity( "Registration Successful").build();
    }

    @POST
    @Path("addGrade")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gradeStudent( AddGradeRequest request ) {
        try {
            gradeCardServices.addGrade(request.getProfessorId(),request.getCourseId(), request.getGrades(),request.getStudentId());
            return Response.status(201).entity("Grades added successfully.").build();
        }
        catch(Exception ex)
        {
            return Response.status(500).entity("couldn't add grades. Reason :- " + ex.getMessage()).build();
        }

    }
}

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

    /**
     * This method is used to view all the courses available.
     * @Param : Nothing
     * @Throws : Nothing
     * @returns : Response
     * */
    @GET
    @Path("/viewAllCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllCourses() {
        try {
            List<Course> courses = new ArrayList<>();
            courses = professorServices.viewCourses();
            return Response.status(200).entity(courses).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Operation Failed :- " + ex.getMessage()).build();
        }
    }

    /**
     * This method is used to view enrolled Students for a particular course
     * @Param : CourseId
     * @Throws : Nothing
     * @returns : Response
     * */
    @GET
    @Path("/viewEnrolledStudents/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledStudents(@PathParam("courseId") int courseId){
        try {
            List<Student> studentList = professorServices.getEnrolledStudents(courseId);
            return Response.status(200).entity(studentList).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Operation Failed :- " + ex.getMessage()).build();
        }
    }

    /**
     * This method is used to view selected course by the professor
     * @Param : ProfessorId
     * @Throws : Nothing
     * @returns : Response
     * */
    @GET
    @Path("/viewSelectedCourses/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewSelectedCourses(@PathParam("professorId") int professorId){
        try {
            List<Course> courses = new ArrayList<>();
            courses = professorServices.viewEnrolledCourses(professorId);
            return Response.status(200).entity(courses).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Operation Failed :- " + ex.getMessage()).build();
        }
    }

    /**
     * This method is used to select the course to teach.
     * @Param : SelectCourseToTeach Object
     * @Throws : Nothing
     * @returns : Response
     * */
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

    /**
     * This method is used to add grade for students.
     * @Param : AddGradeRequest Object
     * @Throws : Nothing
     * @returns : Response
     * */
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
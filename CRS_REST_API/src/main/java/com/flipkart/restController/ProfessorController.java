package com.flipkart.restController;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.CourseDB;
import com.flipkart.services.ProfessorServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/professor")
public class ProfessorController {

    private static ProfessorServices professorServices = new ProfessorServices(new CourseDB());
    @GET
    @Path("/viewAllCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllCourses() {
        try {
            System.out.println("In professor");
            List<Course> courses = new ArrayList<>();
            courses = professorServices.viewCourses();
            return Response.status(200).entity(courses).build();
        }
        catch(Exception ex)
        {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }

    @GET
    @Path("/viewEnrolledStudents/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewEnrolledStudents(@PathParam("courseId") int courseId){
        try {
            System.out.println("In professor");
            List<Student> studentList = professorServices.getEnrolledStudents(courseId);
            return Response.status(200).entity(studentList).build();
        }
        catch(Exception ex)
        {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }

    @GET
    @Path("/viewSelectedCourses/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewSelectedCourses(@PathParam("professorId") int professorId) {
        try {
            System.out.println("In professor");
            List<Course> courses = new ArrayList<>();
            courses = professorServices.viewEnrolledCourses(professorId);
            return Response.status(200).entity(courses).build();
        }
        catch(Exception ex)
        {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }
}

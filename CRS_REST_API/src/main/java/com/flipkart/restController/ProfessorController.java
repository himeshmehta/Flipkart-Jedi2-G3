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
}

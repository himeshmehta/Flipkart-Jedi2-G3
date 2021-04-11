package com.flipkart.restController;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.Course;
import com.flipkart.requestPojo.NewCoursePOJO;
import com.flipkart.requestPojo.NewUser;
import com.flipkart.services.AdminServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/admin")
public class AdminController {

    private static AdminServices adminServices = new AdminServices();

    @GET
    @Path("/notApprovedStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewNotApprovedStudents() throws CRSException {
        try {
            List<Integer> userIds = adminServices.getNotApprovedStudents();
            return Response.status(200).entity(userIds).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Something went wrong, Please Try Again ! ").build();
        }
    }

    @POST
    @Path(("/addNewUser"))
    public Response addNewUSer(NewUser newUserRequest) throws InvalidDataException, CRSException {
        try {
            Boolean isUserAdded = adminServices.addUser(newUserRequest.getUser(), newUserRequest.getPassword());
            return Response.status(200).entity(isUserAdded ? "user added successfully." : "user not added.").build();
        } catch (Exception ex) {
            return Response.status(500).entity( "User Addition Failed, Please Try Again ! ").build();
        }
    }

    @POST
    @Path(("/addNewCourse"))
    public Response addNewCourse(NewCoursePOJO newCoursePOJO) throws InvalidDataException, CRSException {
        try {
            adminServices.addNewCourse(newCoursePOJO.getDescription(), newCoursePOJO.getCourseName(), newCoursePOJO.getFee());
            return Response.status(200).entity("New Course added successfully").build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Course Addition Failed, Please Try Again ! ").build();
        }
    }

    @DELETE
    @Path("/removeUser/{userId}")
    public Response removeUser(@PathParam("userId") int userId) throws CRSException {
        try {
            adminServices.removeUser(userId);
            return Response.status(200).entity("User removed successfully").build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Course removal Failed, Please Try Again ! ").build();
        }
    }

    @PUT
    @Path("/approveStudent/{studentId}")
    public Response approveStudents(@PathParam("studentId") int studentIds) throws CRSException {
        try {
            adminServices.approveStudent(studentIds);
            return Response.status(200).entity("Student approved successfully").build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Student Approval Failed, Please Try Again ! ").build();
        }
    }
}

package com.flipkart.restController;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.requestPojo.NewCourseRequest;
import com.flipkart.requestPojo.NewUserRequest;
import com.flipkart.services.AdminServices;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type admin controller
 */
@Path("/admin")
public class AdminController {

    private static AdminServices adminServices = new AdminServices();

    private final Validator validator;


    public AdminController(Validator validator) {
        this.validator = validator;
    }

    /**
     * Gets the list of not approved students
     * @return
     * @throws CRSException
     */

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

    /**
     * Add new user
     * @param newUserRequest
     * @return
     */
    @POST
    @Path(("/addNewUser"))
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewUSer(NewUserRequest newUserRequest) {
        try {
            User user = adminServices.addUser(newUserRequest.getUser(), newUserRequest.getPassword());
            return Response.status(200).entity(user).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Can not add user. Reason :- " + ex.getMessage()).build();
        }
    }

    /**
     * Add new course
     * @param newCoursePOJO
     * @return
     */
    @POST
    @Path(("/addNewCourse"))
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCourse(NewCourseRequest newCourseRequest) {
        try {
            Course course = adminServices.addNewCourse(newCourseRequest.getDescription(), newCourseRequest.getCourseName(), newCourseRequest.getFee());
            return Response.status(200).entity(course).build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Course Addition Failed, Please Try Again ! ").build();
        }
    }

    /**
     * Remove user
     * @param userId
     * @return
     * @throws CRSException
     */
    @DELETE
    @Path("/removeUser/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeUser(@PathParam("userId") int userId) throws CRSException {
        try {
            adminServices.removeUser(userId);
            return Response.status(200).entity("User removed successfully").build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Course removal Failed, Please Try Again ! ").build();
        }
    }

    /**
     * Approve student registration
     * @param studentIds
     * @return
     * @throws CRSException
     */
    @PUT
    @Path("/approveStudent/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response approveStudents(@PathParam("studentId") int studentIds) throws CRSException {
        try {
            adminServices.approveStudent(studentIds);
            return Response.status(200).entity("Student approved successfully").build();
        } catch (Exception ex) {
            return Response.status(500).entity( "Student Approval Failed, Please Try Again ! ").build();
        }
    }
}

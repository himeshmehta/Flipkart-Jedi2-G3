package com.flipkart.restController;

import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.CourseRegistrationException;
import com.flipkart.bean.Course;
import com.flipkart.services.AdminServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        List<Integer> userIds = adminServices.getNotApprovedStudents();
        return Response.status(200).entity(userIds).build();
    }
}

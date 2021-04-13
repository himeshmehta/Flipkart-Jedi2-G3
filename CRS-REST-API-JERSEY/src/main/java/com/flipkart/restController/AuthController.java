package com.flipkart.restController;

import com.flipkart.Exception.CRSException;
import com.flipkart.bean.User;
import com.flipkart.requestPojo.LoginRequest;
import com.flipkart.requestPojo.SelfRegistrationRequest;
import com.flipkart.services.AuthDBServices;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type authorization controller
 */
@Path("/auth")
public class AuthController {

    private static  AuthDBServices authDBServices = new AuthDBServices();



    public AuthController() {

    }

    /**
     * Login of user
     * @param loginDetails
     * @return
     */
    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginDetails){
        try {
            User user =  authDBServices.authenticateUser(loginDetails.getUserId(),loginDetails.getPassword());
            return Response.status(200).entity(user).build();
        } catch (Exception e) {
            return Response.status(500).entity("Login Failed. Reason :- " + e.getMessage()).build();
        }
    }

    /**
     * Self Registeration of user
     * @param request
     * @return
     */
    @POST
    @Path("/selfRegistration")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selfRegistration(SelfRegistrationRequest request){
        try{
            User user = authDBServices.selfRegisterStudent(request.getEmail(), request.getName(), request.getPassword(), request.getConfirmPassword());
            return Response.status(200).entity(user).build();
        } catch (CRSException e) {
            return Response.status(500).entity("Sign Up failed :- " + e.getMessage()).build();
        }
    }
}

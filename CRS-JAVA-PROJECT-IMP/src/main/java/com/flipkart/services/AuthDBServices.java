package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.InvalidInputException;
import com.flipkart.bean.User;
import com.flipkart.constants.Role;
import com.flipkart.dao.AuthDB;

import java.util.logging.Logger;

public class AuthDBServices implements AuthDBInterface{

    private AuthDB authDBOperations;

    public AuthDBServices(){
        this.authDBOperations = new AuthDB();
    }
    private static final Logger logger = Logger.getLogger(String.valueOf(AuthDBServices.class));

    @Override
    public User authenticateUser(String userId, String password) throws AuthorizationException {

        User user = authDBOperations.AuthenticateUser(userId,password);
        logger.info("Authenticating User");
        return user;
    }

    @Override
    public void selfRegistration(User user) throws InvalidInputException {
        // This method is only applicable for student
        if(!Role.STUDENT.equals(user.getRole())){
            throw new InvalidInputException("Only student can self register.");
        }
    }
}

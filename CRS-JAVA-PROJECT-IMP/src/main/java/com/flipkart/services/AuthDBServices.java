package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;
import com.flipkart.helper.UserValidator;

import org.apache.log4j.Logger;

public class AuthDBServices implements AuthDBInterface{

    private AuthDB authDBOperations;

    public AuthDBServices(){
        this.authDBOperations = new AuthDB();
    }
    private static final Logger logger = Logger.getLogger(AuthDBServices.class);

    @Override
    public User authenticateUser(int userId, String password) throws AuthorizationException {

        User user = authDBOperations.AuthenticateUser(userId,password);
        logger.info("Authenticating User");
        return user;
    }

    @Override
    public Boolean selfRegisterStudent(String email, String name, String password, String confirmPassword) throws CRSException {
        Boolean isSignedUp = false;
        try{
            UserValidator.selfRegisterValidator(email,password,confirmPassword);
            isSignedUp = authDBOperations.selfRegisterStudent(email,name,password);
        } catch (InvalidDataException e) {
            throw new CRSException(e.getMessage());
        }
        return isSignedUp;
    }

}

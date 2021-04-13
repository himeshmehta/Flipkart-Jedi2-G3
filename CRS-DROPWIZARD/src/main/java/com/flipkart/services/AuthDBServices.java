package com.flipkart.services;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.Exception.CRSException;
import com.flipkart.Exception.InvalidDataException;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthDB;
import com.flipkart.helper.UserValidator;

import java.util.logging.Logger;

public class AuthDBServices implements AuthDBInterface{

    private AuthDB authDBOperations;

    public AuthDBServices(){
        this.authDBOperations = AuthDB.getInstance();
    }
    private static final Logger logger = Logger.getLogger(String.valueOf(AuthDBServices.class));

    @Override
    public User authenticateUser(int userId, String password) throws AuthorizationException {

        User user = authDBOperations.AuthenticateUser(userId,password);
        logger.info("Authenticating User");
        return user;
    }

    @Override
    public User selfRegisterStudent(String email, String name, String password, String confirmPassword) throws CRSException {
        User user = null;
        try{
            UserValidator.selfRegisterValidator(email,password,confirmPassword);
            user = authDBOperations.selfRegisterStudent(email,name,password);
        } catch (InvalidDataException e) {
            throw new CRSException(e.getMessage());
        }
        return user;
    }

}

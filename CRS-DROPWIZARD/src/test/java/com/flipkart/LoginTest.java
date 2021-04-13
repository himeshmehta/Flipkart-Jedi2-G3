package com.flipkart;

import com.flipkart.Exception.AuthorizationException;
import com.flipkart.bean.User;
import com.flipkart.services.AuthDBServices;
import org.junit.Test;
import org.junit.Assert;

public class LoginTest {

    private AuthDBServices authDBServices = new AuthDBServices();
    @Test
    public void loginTest1(){
        // Should throw AuthorizationException  when user id does not exists in database
        try {
            authDBServices.authenticateUser(1000,"12345");
        } catch (AuthorizationException ex) {
            String errorMessage = ex.getMessage();
            Assert.assertEquals("user id does not exists.",errorMessage);
        }
    }

    @Test
    public void loginTest2(){
        // Should throw AuthorizationException when password is incorrect
        try {
            authDBServices.authenticateUser(1,"12346");
        } catch (AuthorizationException ex) {
            String errorMessage = ex.getMessage();
            Assert.assertEquals("Incorrect password",errorMessage);
        }
    }
}

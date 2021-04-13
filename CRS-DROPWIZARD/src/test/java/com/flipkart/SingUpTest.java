package com.flipkart;

import com.flipkart.Exception.CRSException;
import com.flipkart.services.AuthDBServices;
import org.junit.Assert;
import org.junit.Test;

public class SingUpTest {

    private AuthDBServices authDBServices = new AuthDBServices();
    @Test
    public void signUpTest1(){
        // should throw CRSException when email is invalid
        try {
                authDBServices.selfRegisterStudent("randomEmail","random","12345","12345");
        } catch (CRSException e) {
            Assert.assertEquals("Please provide a valid email",e.getMessage());
        }
    }

    @Test
    public void signUpTest2(){
        // should throw CRSException when password is weak
        try {
            authDBServices.selfRegisterStudent("random@gmail.com","random","1234","1234");
        } catch (CRSException e) {
            Assert.assertEquals("Weak password. Password should contain minimum 5 digits.",e.getMessage());
        }
    }

    @Test
    public void signUpTest3(){
        // should throw CRSException when password and confirm password do not matches
        try {
            authDBServices.selfRegisterStudent("random@gmail.com","random","123456","12345");
        } catch (CRSException e) {
            Assert.assertEquals("Your confirm password do not match with actual password",e.getMessage());
        }
    }
}

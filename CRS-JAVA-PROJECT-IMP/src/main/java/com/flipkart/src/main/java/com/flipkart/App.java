package com.flipkart.src.main.java.com.flipkart;

//import com.dropwizard.rest.EmployeeController;
//import com.dropwizard.rest.HelloController;
import com.flipkart.restController.AdminController;
import com.flipkart.restController.AuthController;
import com.flipkart.restController.ProfessorController;
import com.flipkart.restController.StudentController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new AdminController(e.getValidator()));
        e.jersey().register(new StudentController(e.getValidator()));
        e.jersey().register(new ProfessorController(e.getValidator()));
        e.jersey().register(new AuthController(e.getValidator()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
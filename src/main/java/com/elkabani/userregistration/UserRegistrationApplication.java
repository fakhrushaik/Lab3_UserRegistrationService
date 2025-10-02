package com.elkabani.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserRegistrationApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(UserRegistrationApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L, "John Doe",  "jdoe@example.com", "password123"));
        userService.registerUser(new User(2L, "Jane Smith",  "jsmith@example.com", "password456"));
     try {
            userService.registerUser(new User(1L, "John Doe",  "jdoe@example.com", "password123"));
        } catch (DuplicateRegistrationException ex) {
            System.out.println("Duplicate registration attempt handled: " + ex.getMessage());
        }
    }

}

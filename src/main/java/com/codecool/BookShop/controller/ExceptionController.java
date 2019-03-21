package com.codecool.BookShop.controller;

import com.codecool.BookShop.service.MailNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
public class ExceptionController {

    private static Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @Autowired
    private MailNotifier mailNotifier;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void exceptionHandler() {
        String message = "Dear administrator,\n Internal server error occurred! Please check server.";
        mailNotifier.sendEmail("dardomanski@gmail.com", "Server allert!", message);

    }

    @GetMapping("/example_error")
    public void raiseException() {
        throw new NullPointerException();
    }

}
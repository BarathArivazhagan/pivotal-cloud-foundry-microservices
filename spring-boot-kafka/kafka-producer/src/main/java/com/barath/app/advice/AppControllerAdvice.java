package com.barath.app.advice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.invoke.MethodHandles;

@RestControllerAdvice
public class AppControllerAdvice {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception ex){

        logger.error("exception occured in controller {} ",ex);
        return  ResponseEntity.badRequest().body(ex.getMessage());
    }
}

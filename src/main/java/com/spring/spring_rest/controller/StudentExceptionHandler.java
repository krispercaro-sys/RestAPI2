
package com.spring.spring_rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.spring.spring_rest.entity.StudentErrorResponse;
import com.spring.spring_rest.exception.StudentNotFoundException;

/**
 * Handles exceptions globally across the REST controllers.
 * Provides appropriate HTTP status codes and error responses.
 */
@ControllerAdvice
public class StudentExceptionHandler {

    /**
     * Handles cases when a requested student cannot be found.
     *
     * @param ex the StudentNotFoundException
     * @return a 404 NOT FOUND response with error details
     */
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(
            StudentNotFoundException ex) {

        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles invalid argument types in request parameters.
     *
     * @param ex the MethodArgumentTypeMismatchException
     * @return a 400 BAD REQUEST response with an error message
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StudentErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex) {

        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(
                "Invalid data. Only integers are accepted");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles validation errors for invalid request data.
     *
     * @param ex the MethodArgumentNotValidException
     * @return a 400 BAD REQUEST response containing field errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
            handleValidationExceptions(
                    MethodArgumentNotValidException ex) {

        Map<String, String> err = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> err.put(
                        error.getField(),
                        error.getDefaultMessage()));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles any other unexpected exceptions.
     *
     * @param ex the general Exception
     * @return a 400 BAD REQUEST response with error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse> handleException(
            Exception ex) {

        ex.printStackTrace();

        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}

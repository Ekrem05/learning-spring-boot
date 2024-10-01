package com.luv2code.restdemo.exception;

import com.luv2code.restdemo.model.StudentErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(404);
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(500);
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(500).body(error);
    }
}

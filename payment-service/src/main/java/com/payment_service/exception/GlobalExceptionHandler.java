package com.payment_service.exception;



import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

   
    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePaymentNotFound(
            PaymentNotFoundException ex) {

    	ErrorResponse error = new ErrorResponse();

    	error.setTimestamp(LocalDateTime.now());
    	error.setStatus(HttpStatus.NOT_FOUND.value());
    	error.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
    	error.setMessage(ex.getMessage());

    	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    
    }

    // Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(),
                       fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex) {

    	ErrorResponse error = new ErrorResponse();

    	error.setTimestamp(LocalDateTime.now());
    	error.setStatus(HttpStatus.NOT_FOUND.value());
    	error.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
    	error.setMessage(ex.getMessage());

    	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        
    }

}

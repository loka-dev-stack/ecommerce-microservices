package com.Userver.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Userver.entity.User;

@RestControllerAdvice
public class GlobalexceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException exc) {

        Map<String, String> errors = new HashMap<>();

        exc.getBindingResult()
          .getFieldErrors()
          .forEach(error ->
              errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String , String>> usernotfoundexception(UserNotFoundException exc){
		HashMap<String, String> error = new HashMap<>();
		error.put("Message", exc.getMessage());
		return ResponseEntity.status(404).body(error);
		
	}
}

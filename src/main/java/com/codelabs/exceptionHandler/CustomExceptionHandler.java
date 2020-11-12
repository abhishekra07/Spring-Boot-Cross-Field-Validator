package com.codelabs.exceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codelabs.exception.ValidationException;
import com.codelabs.response.BaseResponse;
import com.codelabs.response.Error;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private HttpHeaders httpHeaders;
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException e){
    	BaseResponse response = new BaseResponse();
    	response.setMessage("Validation Failed");
    	response.setErrors(getErrorList(e.getErrorCodes()));
    	return new ResponseEntity<>(response, httpHeaders, HttpStatus.BAD_REQUEST);
    }
    
    private List<com.codelabs.response.Error> getErrorList(Set<String> errorMessages) {
    	List<com.codelabs.response.Error> errors = new ArrayList<>();
    	for(String message: errorMessages) {
    		com.codelabs.response.Error error = new Error();
    		error.setMessage(message);
    		errors.add(error);
    	}
    	return errors;
    }
}
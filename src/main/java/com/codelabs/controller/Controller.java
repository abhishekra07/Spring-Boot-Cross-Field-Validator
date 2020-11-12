package com.codelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.request.UserValidation;
import com.codelabs.response.BaseResponse;
import com.codelabs.validator.RequestValidator;

@RestController
@RequestMapping(value = "/api/validator")
public class Controller {
	
	@Autowired
	RequestValidator validator;
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@PostMapping
	public ResponseEntity<BaseResponse> validateInputs(@RequestBody UserValidation userInput) {
		validator.validate(userInput);
		BaseResponse response = new BaseResponse();
		response.setMessage("All Validation Passed!!!!");
		return new ResponseEntity<>(response, httpHeaders, HttpStatus.OK);
	}
}

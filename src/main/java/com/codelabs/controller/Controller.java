package com.codelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.request.UserValidation;
import com.codelabs.validator.RequestValidator;

@RestController
@RequestMapping(value = "/api/validator")
public class Controller {
	
	@Autowired
	RequestValidator validator;
	
	@PostMapping
	public boolean validateInputs(@RequestBody UserValidation userInput) {
		validator.validate(userInput);
		return true;
	}
}

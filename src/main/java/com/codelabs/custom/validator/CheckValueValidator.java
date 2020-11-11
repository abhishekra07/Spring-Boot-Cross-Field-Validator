package com.codelabs.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codelabs.custom.annotation.CheckValue;;
public class CheckValueValidator implements ConstraintValidator<CheckValue, String>{

	@Override
    public void initialize(CheckValue checkValue) {
		
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}

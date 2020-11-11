package com.codelabs.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codelabs.custom.annotation.CrossField;

public class CrossFieldValidator implements ConstraintValidator<CrossField, Object>{

	@Override
    public void initialize(CrossField crossField) {
		
    }
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}

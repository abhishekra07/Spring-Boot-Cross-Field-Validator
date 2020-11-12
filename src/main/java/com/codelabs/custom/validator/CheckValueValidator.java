package com.codelabs.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codelabs.custom.annotation.CheckValue;
import com.codelabs.utility.Constants;
import com.codelabs.utility.ErrorConstants;;
public class CheckValueValidator implements ConstraintValidator<CheckValue, String>{

	String key = null;
	String type=null;
	@Override
    public void initialize(CheckValue checkValue) {
		this.key = checkValue.key();
		this.type = checkValue.type();
    }
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean isValid = true;
		if(value != null) {
			if(type.equals(Constants.USER_ID)) {
				isValid = validateUserId(value);
			}else if(type.equals(Constants.EMAIL_ID)) {
				isValid = validateEmailAddress(value);
			}else if(type.equals(Constants.VERIFY_EMAIL_ID)) {
				isValid = validateEmailAddress(value);
			}
		}
		return false;
	}

	private boolean validateEmailAddress(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validateUserId(String value) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.codelabs.custom.validator;


import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codelabs.custom.annotation.CheckValue;
import com.codelabs.utility.Constants;;
public class CheckValueValidator implements ConstraintValidator<CheckValue, String>{

	String key = null;
	String type=null;
	
	//this is some dummy values to validate but we can use db to validate user id here
	List<String> allowedUserIds = Arrays.asList("abhi123","abhi07","victor");
			
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
		
		//this to disable default constraint and use custom error messages
		if(!isValid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(key).addConstraintViolation();
		}
		return isValid;
	}

	private boolean validateEmailAddress(String value) {
		if(!value.isBlank() && value.matches(Constants.EMAIL_REGEX))
			return true;
		return false;
	}

	private boolean validateUserId(String value) {
		if(!value.isBlank() && allowedUserIds.contains(value))
			return true;
		return false;
	}

}

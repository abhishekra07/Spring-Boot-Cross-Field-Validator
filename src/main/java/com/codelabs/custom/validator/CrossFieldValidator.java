package com.codelabs.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codelabs.custom.annotation.CrossField;
import com.codelabs.request.UserValidation;
import com.codelabs.utility.Constants;
import com.codelabs.utility.ErrorConstants;

public class CrossFieldValidator implements ConstraintValidator<CrossField, Object>{
	
	String code = null;

	@Override
    public void initialize(CrossField crossField) {
		this.code = crossField.code();
    }
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean isValid = true;
		
		//here i have one class but this annotation can be used to validate class
		if(code.equals(Constants.CROSS_FIELD_INPUT) && value != null) {
			isValid = validateEmailAddress((UserValidation) value,context);
			isValid = validatePassword((UserValidation) value,context);
		}
		return isValid;
	}
	
	private boolean validatePassword(UserValidation value, ConstraintValidatorContext context) {
		if(value.getEmailAddress().equals(value.getVerifyEmailAddress()))
			return true;
		setConstraintViolationError(ErrorConstants.EMAIL_NOT_MATCH,context);
		return false;
	}

	private boolean validateEmailAddress(UserValidation value, ConstraintValidatorContext context) {
		if(value.getPassword().equals(value.getVerifyPassword()))
			return true;
		setConstraintViolationError(ErrorConstants.PASSWORD_NOT_MATCH,context);
		return false;
	}

	private void setConstraintViolationError(String errorMessage, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
	}
}

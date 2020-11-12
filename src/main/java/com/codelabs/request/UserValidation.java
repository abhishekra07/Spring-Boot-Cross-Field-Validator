package com.codelabs.request;

import com.codelabs.custom.annotation.CheckValue;
import com.codelabs.custom.annotation.CrossField;
import com.codelabs.utility.Constants;
import com.codelabs.utility.ErrorConstants;

@CrossField.List(value = {@CrossField(code = Constants.CROSS_FIELD_INPUT)})
public class UserValidation {
	
	@CheckValue(key = ErrorConstants.INVALID_USER_ID, type = Constants.USER_ID)
	private String userId;

	@CheckValue(key = ErrorConstants.INVALID_EMAIL_ID, type = Constants.EMAIL_ID)
	private String emailAddress;
	
	@CheckValue(key = ErrorConstants.INVALID_VERIFY_EMAIL_ID, type = Constants.VERIFY_EMAIL_ID)
	private String verifyEmailAddress;
	
	private String password;
	
	private String verifyPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public String getVerifyEmailAddress() {
		return verifyEmailAddress;
	}

	public void setVerifyEmailAddress(String verifyEmailAddress) {
		this.verifyEmailAddress = verifyEmailAddress;
	}
	
}

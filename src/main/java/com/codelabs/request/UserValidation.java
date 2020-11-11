package com.codelabs.request;

import com.codelabs.custom.annotation.CheckValue;

public class UserValidation {
	
	@CheckValue
	private String userId;

	@CheckValue
	private String emailAddress;
	
	@CheckValue
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

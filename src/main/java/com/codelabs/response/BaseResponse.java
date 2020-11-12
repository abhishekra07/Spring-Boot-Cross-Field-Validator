package com.codelabs.response;

import java.util.List;

public class BaseResponse {
	private String message;
	
	List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

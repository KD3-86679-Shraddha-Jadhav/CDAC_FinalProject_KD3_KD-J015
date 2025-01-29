package com.rto.custom_exception;

public class ApiException extends RuntimeException {

	public ApiException(String errMesg) {
		super(errMesg);
	}
}

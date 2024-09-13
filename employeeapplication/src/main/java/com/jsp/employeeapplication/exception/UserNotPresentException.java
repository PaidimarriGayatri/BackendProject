package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class UserNotPresentException extends RuntimeException {
	private String msg = "employee is not present";

	public UserNotPresentException(String msg) {
		super();
		this.msg = msg;
	}

	public UserNotPresentException() {
		super();
	}

}

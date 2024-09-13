package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class IdWrongException extends RuntimeException {
	private String msg = "email is wrong";

	public IdWrongException(String msg) {
		super();
		this.msg = msg;
	}

	public IdWrongException() {
		super();
	}

}

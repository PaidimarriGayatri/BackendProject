package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class IdNotPresentException extends RuntimeException {
	private String msg = "Id is not present";

	public IdNotPresentException(String message) {
		super(message);
		this.msg = message;
	}

	public IdNotPresentException() {
		super();
	}

}

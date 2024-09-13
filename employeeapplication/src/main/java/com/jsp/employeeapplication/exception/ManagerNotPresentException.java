package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class ManagerNotPresentException extends RuntimeException {
	private String msg = "Manager is not present";

	public ManagerNotPresentException(String msg) {
		super();
		this.msg = msg;
	}

	public ManagerNotPresentException() {
		super();
	}

}

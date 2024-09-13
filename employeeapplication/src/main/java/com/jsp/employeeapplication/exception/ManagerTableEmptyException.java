package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class ManagerTableEmptyException extends RuntimeException {
	private String msg = "manager table is Empty";

	public ManagerTableEmptyException(String msg) {
		super();
		this.msg = msg;
	}

	public ManagerTableEmptyException() {
		super();
	}

}

package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class EmployeeTableEmptyException extends RuntimeException {
	private String msg = "employee table is Empty";

	public EmployeeTableEmptyException(String msg) {
		super();
		this.msg = msg;
	}

	public EmployeeTableEmptyException() {
		super();
	}

}

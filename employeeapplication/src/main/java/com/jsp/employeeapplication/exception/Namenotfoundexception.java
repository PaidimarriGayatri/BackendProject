package com.jsp.employeeapplication.exception;

import lombok.Data;

@Data
public class Namenotfoundexception extends RuntimeException {
	private String msg = "Name cant be null";

	public Namenotfoundexception(String msg) {
		super();
		this.msg = msg;
	}

	public Namenotfoundexception() {
		super();
	}


	
	
}

package com.daw.exceptions;

public class FieldNotNullException extends RuntimeException {

	private static final long serialVersionUID = -6924055668963153141L;
	
	public FieldNotNullException(String field) {
		super("Error, el campo " + field + " no puede ser nulo.");
	}

}

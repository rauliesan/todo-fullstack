package com.daw.exceptions;

public class DuplicatedBookException extends RuntimeException {

	private static final long serialVersionUID = -6924055668963153141L;
	
	public DuplicatedBookException(String isbn) {
		super("Error, ya existe un libro con isbn: " + isbn);
	}

}

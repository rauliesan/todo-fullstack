package com.daw.exceptions;

public class ReferencedBookException extends RuntimeException {

	private static final long serialVersionUID = -6924055668963153141L;
	
	public ReferencedBookException() {
		super("No se puede eliminar el libro porque existen prestamos asociados");
	}

}

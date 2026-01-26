package com.daw.exceptions;

public class LibroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8728060184871678581L;
	
	public LibroNotFoundException(Long id) {
		super("Error, no se ha podido encontrar un Libro con el id " + id);
	}

}

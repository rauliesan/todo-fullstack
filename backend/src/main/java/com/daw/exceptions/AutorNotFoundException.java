package com.daw.exceptions;

public class AutorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6457915556276010515L;
	
	public AutorNotFoundException(Long id) {
		super("Error, no se ha podido encontrar un Autor con el id " + id);
	}

}

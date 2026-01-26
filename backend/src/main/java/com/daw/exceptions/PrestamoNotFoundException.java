package com.daw.exceptions;

public class PrestamoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6457915556276010515L;
	
	public PrestamoNotFoundException(Long id) {
		super("Error, no se ha podido encontrar un Prestamo con el id " + id);
	}

}

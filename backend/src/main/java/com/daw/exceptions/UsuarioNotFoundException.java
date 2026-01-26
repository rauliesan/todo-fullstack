package com.daw.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -9185928691949713948L;
	
	public UsuarioNotFoundException(Long id) {
		super("Error, no se ha podido encontrar un Usuario con el id " + id);
	}

}

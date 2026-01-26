package com.daw.controller.dto;

import lombok.Data;

@Data
public class LibroDTO {

	private String isbn;
	
	private String titulo;
	
	private String descripcion;
	
	private String categoria;
	
	private Integer anioPublicacion;
	
	private Integer copiasDisponibles;
	
	private Boolean activo;
	
	private Long idAutor;
	
}

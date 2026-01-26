package com.daw.controller.dto;

import java.time.LocalDate;

import com.daw.datamodel.entity.Estado;

import lombok.Data;

@Data
public class PrestamoDTO {

	private LocalDate fechaPrestamo;
	
	private LocalDate fechaDevolucionPrevista;
	
	private LocalDate fechaDevolucionReal;
	
	private Estado estado;
	
	private Long idUsuario;
	
	private Long idLibro;
	
}

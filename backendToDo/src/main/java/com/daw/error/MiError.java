package com.daw.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
public class MiError {
	
	private HttpStatus estado;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime fechaYHora;
	
	private String mensaje;
	
}

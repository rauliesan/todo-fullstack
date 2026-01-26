package com.daw.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.daw.controller.dto.AutorDTO;
import com.daw.controller.dto.LibroDTO;
import com.daw.controller.dto.PrestamoDTO;
import com.daw.controller.dto.UsuarioDTO;
import com.daw.datamodel.entity.Autor;
import com.daw.datamodel.entity.Libro;
import com.daw.datamodel.entity.Prestamo;
import com.daw.datamodel.entity.Usuario;
import com.daw.datamodel.repository.RepositorioAutores;
import com.daw.datamodel.repository.RepositorioLibros;
import com.daw.datamodel.repository.RepositorioPrestamos;
import com.daw.datamodel.repository.RepositorioUsuarios;
import com.daw.exceptions.AutorNotFoundException;
import com.daw.exceptions.LibroNotFoundException;
import com.daw.exceptions.PrestamoNotFoundException;
import com.daw.exceptions.ReferencedBookException;
import com.daw.exceptions.UsuarioNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class Servicio {
	
	private final RepositorioAutores repAutores;
	private final RepositorioLibros repLibros;
	private final RepositorioPrestamos repPrestamos;
	private final RepositorioUsuarios repUsuarios;
	
	public List<Libro> listarLibros() {
		return repLibros.findAll();
	}

	public Libro buscarLibro(Long id) {
		return repLibros.findById(id).orElseThrow(() -> new LibroNotFoundException(id));
	}

	public Libro crearLibro(LibroDTO libroDTO) {
		Libro libro = new Libro();
		libro.setIsbn(libroDTO.getIsbn());
		libro.setTitulo(libroDTO.getTitulo());
		libro.setDescripcion(libroDTO.getDescripcion());
		libro.setActivo(libroDTO.getActivo());
		libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
		libro.setCopiasDisponibles(libroDTO.getCopiasDisponibles());
		libro.setCategoria(libroDTO.getCategoria());
		libro.setAutor(buscarAutor(libroDTO.getIdAutor()));
		try {
			return repLibros.save(libro);
		} catch(DataIntegrityViolationException ex) {
			// hay que comprobar la unicidad o los campos oblitatorios
			return null;
		}
	}

	public Libro actualizarLibro(Long id, LibroDTO libroDTO) {
		Libro libro = buscarLibro(id);
		libro.setIsbn(libroDTO.getIsbn());
		libro.setTitulo(libroDTO.getTitulo());
		libro.setDescripcion(libroDTO.getDescripcion());
		libro.setActivo(libroDTO.getActivo());
		libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
		libro.setCopiasDisponibles(libroDTO.getCopiasDisponibles());
		libro.setCategoria(libroDTO.getCategoria());
		libro.setAutor(buscarAutor(libroDTO.getIdAutor()));
		try {
			return repLibros.save(libro);
		} catch(DataIntegrityViolationException ex) {
			// hay que comprobar la unicidad o los campos oblitatorios
			return null;
		}
	}

	public void eliminarLibro(Long id) {
		Libro libro = buscarLibro(id);
		try {
			repLibros.delete(libro);
		} catch(DataIntegrityViolationException ex) {
			throw new ReferencedBookException();
		}
	}

	public List<Autor> listarAutores() {
		return repAutores.findAll();
	}

	public Autor buscarAutor(Long id) {
		return repAutores.findById(id).orElseThrow(() -> new AutorNotFoundException(id));
	}

	public Autor crearAutor(AutorDTO autorDTO) {
		Autor autor = new Autor();
		autor.setNombre(autorDTO.getNombre());
		autor.setDescripcion(autorDTO.getDescripcion());
		autor.setNacionalidad(autorDTO.getNacionalidad());
		try {
			return repAutores.save(autor);
		} catch(DataIntegrityViolationException ex) {
			//hay que comprobar los campos obligatorios
			return null;
		}
	}

	public Autor actualizarAutor(Long id, AutorDTO autorDTO) {
		Autor autor = buscarAutor(id);
		autor.setNombre(autorDTO.getNombre());
		autor.setDescripcion(autorDTO.getDescripcion());
		autor.setNacionalidad(autorDTO.getNacionalidad());
		try {
			return repAutores.save(autor);
		} catch(DataIntegrityViolationException ex) {
			//hay que comprobar los campos obligatorios
			return null;
		}
	}

	public void eliminarAutor(Long id) {
		Autor autor = buscarAutor(id);
		if(autor.getLibros().size()==0) {
			repAutores.delete(autor);
		}
	}

	public List<Usuario> listarUsuarios() {
		return repUsuarios.findAll();
	}

	public Usuario buscarUsuario(Long id) {
		return repUsuarios.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id));
	}

	public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setDni(usuarioDTO.getDni());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setTelefono(usuarioDTO.getTelefono());
		usuario.setEmail(usuarioDTO.getEmail());
		try {
			return repUsuarios.save(usuario);
		} catch(DataIntegrityViolationException ex) {
			// hay que comprobar la unicidad o los campos oblitatorios
			return null;
		}
	}

	public Usuario actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuario = buscarUsuario(id);
		usuario.setDni(usuarioDTO.getDni());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setTelefono(usuarioDTO.getTelefono());
		usuario.setEmail(usuarioDTO.getEmail());
		try {
			return repUsuarios.save(usuario);
		} catch(DataIntegrityViolationException ex) {
			// hay que comprobar la unicidad o los campos oblitatorios
			return null;
		}
	}

	public void eliminarUsuario(Long id) {
		Usuario usuario = buscarUsuario(id);
		if(usuario.getPrestamos().size()==0) {
			repUsuarios.delete(usuario);
		}
	}

	public List<Prestamo> listarPrestamos() {
		return repPrestamos.findAll();
	}

	public Prestamo buscarPrestamo(Long id) {
		return repPrestamos.findById(id).orElseThrow(() -> new PrestamoNotFoundException(id));
	}

	public Prestamo crearPrestamo(PrestamoDTO prestamoDTO) {
//		Prestamo prestamo = new Prestamo();
//		prestamo
		return null;
	}

	public Prestamo devolverPrestamo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminarPrestamo(Long id) {
		// TODO Auto-generated method stub
		
	}

	

	
}

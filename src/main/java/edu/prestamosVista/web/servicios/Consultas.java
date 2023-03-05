package edu.prestamosVista.web.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.prestamosVista.aplicacion.dal.AlumnoRepositorio;
import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dal.PortatilRepositorio;
import edu.prestamosVista.aplicacion.dal.Usuarios;
import edu.prestamosVista.aplicacion.dal.UsuariosRepositorio;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DTOUtiles;
import edu.prestamosVista.aplicacion.dto.UsuariosDTO;

//Servicio donde realizaremos las consultas para las diferentes funciones. 
@Service
public class Consultas implements ConsultasInterfaz{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//Lista de AlumnosDTO
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
	
	//Mensajes de confirmación
	String mensaje = null;
	
	//Id elegida del Alumno para borrarlo 
	int idSeleccionada = 0;
	
	//Util para pasar informacion desde los formularios
	DTOUtiles dtoUtil = new DTOUtiles();


	//Inyectamos interfaces
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	@Autowired
	PortatilRepositorio portatilRepositorio;
	
	@Autowired
	UsuariosRepositorio usuarioRepositorio;
	
	
	//Metodo para hacer un listado de todos los alumnos
	public List<Alumnos> listarTodosAlumnos(){	
		
		List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
		
		for (Alumnos alumnos : alumnoRepositorio.findAll()) {
			
			listaAlumnos.add(alumnos);		
		}
		
		return listaAlumnos;
	}
	
	//Metodo para guardar alumnos
	public void guardaAlumno(Alumnos nuevoAlumno) {
		
		try {

			alumnoRepositorio.save(nuevoAlumno);
			
		} catch (Exception e) {
			
			System.out.println("NO SE HA REALIZADO EL GUARDADO. Se ha producido un error: " + e);
			mensaje = "NO SE HA REALIZADO EL GUARDADO. Se ha producido un error, intentelo de nuevo.";
		}
		
	}
	
	
	//Metodo para buscar un alumno mediante su ID
	public Optional<Alumnos> buscaAlumno(int idAlumno) {
		
		try {
			Optional<Alumnos> alumnoSeleccionado = alumnoRepositorio.findById(idAlumno);
			return alumnoSeleccionado;
			
		} catch (Exception e) {
			
			mensaje = "El usuario no existe.";
			System.out.println("El usuario no existe. Error: " + e);
			
			//Retornamos el objeto vacio
			return java.util.Optional.empty();
		}
		
		
	}
	
	
	//Metodo para consultar todos los portatiles
	public List<Portatil> listarTodosPortatiles(){	
		
		List<Portatil> listaPortatiles = new ArrayList<>();
		
		for (Portatil portatil : portatilRepositorio.findAll()) {
			
			listaPortatiles.add(portatil);		
		}
		
		return listaPortatiles;
	}
	
	
	//Metodo para buscar un portatil mediante su codigo de identificacion. 
	public Optional<Portatil> buscaPortatil(String idPortatil) {
		
		try {
			
			Optional<Portatil> portatilSeleccionado = portatilRepositorio.findById(idPortatil);
			
			return portatilSeleccionado;
			
		} catch (Exception e) {
			mensaje = "El portatil no existe.";
			System.out.println("El portatil no existe. Error: " + e);
			
			//Retornamos el objeto vacio
			return java.util.Optional.empty();
		}
			
	}
	
	
	//Metodo para guardar alumnos
	public void guardaPortatil(Portatil nuevoPortatil) {
		
		try {
			
			portatilRepositorio.save(nuevoPortatil);
			
		} catch (Exception e) {
			
			System.out.println("NO SE HA REALIZADO EL GUARDADO. Se ha producido un error: " + e);
			mensaje = "NO SE HA REALIZADO EL GUARDADO. Se ha producido un error, intentelo de nuevo.";
		}
		
	}
	
	//Metodo para borrar portatiles
	public void borraAlumnoporID(int idPortatil) {
		
		try {
			
			alumnoRepositorio.deleteById(idPortatil);
			
		} catch (Exception e) {

			System.out.println("NO SE HA REALIZADO EL BORRADO. Se ha producido un error: " + e);
			mensaje = "NO SE HA REALIZADO EL BORRADO. Se ha producido un error, intentelo de nuevo.";
		}
		
	}
	
	/**
	 * Metodo para guardar registrar nuevos Usuarios.
	 * @param usuario --> Usuario que se va a guardar en la BD
	 */
	public void registraUsuario(Usuarios usuario) {
		
		usuarioRepositorio.save(usuario);
	}

	/**
	 * Metodo para buscar un usuario para el login al que le introducimos un usuario
	 * @param usuario --> Usuario que se va a loguear
	 */
	@Override
	public Usuarios buscaUsuario(UsuariosDTO usuario) {
		
		List<Usuarios> listaUsuarios = (List<Usuarios>) usuarioRepositorio.findAll();
		Usuarios usuarioEncontrado = null;
		
		for (Usuarios usu : listaUsuarios) {
			if(usuario.getNombre_Usuario().equals(usu.getNombre_Usuario()) && usuario.getClave_Usuario().equals(usu.getClave_Usuario())) {
				usuarioEncontrado = usu;
				break;
			
			}
			else {
				usuarioEncontrado = null;
			}
		}
		
		return usuarioEncontrado;
	}
}

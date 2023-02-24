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
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DTOUtiles;

//Servicio donde realizaremos las consultas para las diferentes funciones. 
@Service
public class Consultas {
	
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
	
	
	//Metodo para hacer un listado de todos los alumnos
	public List<Alumnos> listarTodosAlumnos(){	
		
		List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
		
		for (Alumnos alumnos : alumnoRepositorio.findAll()) {
			
			listaAlumnos.add(alumnos);		
		}
		
		return listaAlumnos;
	}
	
	
	//Metodo para buscar un alumno mediante su ID
	public Optional<Alumnos> buscaAlumno(int idAlumno) {
		
		Optional<Alumnos> alumnoSeleccionado = alumnoRepositorio.findById(idAlumno);
		
		return alumnoSeleccionado;
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
			
		Optional<Portatil> portatilSeleccionado = portatilRepositorio.findById(idPortatil);
			
		return portatilSeleccionado;
	}

}
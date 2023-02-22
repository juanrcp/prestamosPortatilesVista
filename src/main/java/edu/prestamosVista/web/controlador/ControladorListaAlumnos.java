package edu.prestamosVista.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.prestamosVista.aplicacion.dal.AlumnoRepositorio;
import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dal.PortatilRepositorio;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DAOaDTO;
import edu.prestamosVista.aplicacion.dto.PortatilesDTO;

//Controlador que gestiona la comunicación entre modelo y vista de la lista de los alumnos
@Controller
public class ControladorListaAlumnos {
	
protected final Log logger = LogFactory.getLog(getClass());
	
	//Lista de Alumnos
	List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	
	//Lista de AlumnosDTO
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
	
	//Mensajes de confirmación
	String mensaje = null;
	
	//Id del alumno seleccionado
	int idSeleccionada = 0;

	

	//Inyectamos interfaz
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	@Autowired
	PortatilRepositorio portatilRepositorio;
	

	//Metodo que extrae a todos los alumnos y los muestra
	@RequestMapping(value="/mostrarAlumnos")
	public ModelAndView mostrarAlumnos(Model model) {
	//Lista de alumnos AUX la cual reiniciaremos cada vez que ejecutamos el metodo. 
	List<AlumnosDTO> listaAlumnosDTOaux = new ArrayList<>();
	DAOaDTO daoadto = new DAOaDTO();
	
	for (Alumnos alumnos : alumnoRepositorio.findAll()) {
		
		listaAlumnosDTOaux.add(daoadto.alumnoDAOaDTO(alumnos));		
	}
		
	//Guardamos la lista dentro de la lista final.
	listaAlumnosDTO = listaAlumnosDTOaux;
	
	int idAlumno = 0;
	model.addAttribute("idAlumno", idAlumno);
	
	miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
		
		return new ModelAndView("ListaAlumnos", "miModelo", miModelo);
	}
	
	@RequestMapping(value="/portatilDeAlumno")
	public ModelAndView portatilDeAlumno(@ModelAttribute("idAlumno") int idAlumno) {
	//Lista de portatiles para encontrar el portatil asignado. 
	List<Portatil> listaPortatiles = new ArrayList<>();
	
	//Buscamos el alumno por su id y lo guardamos en el modelo
	Optional<Alumnos> alumnoSeleccionado = alumnoRepositorio.findById(idAlumno);
	miModelo.put("alumnoSeleccionado", alumnoSeleccionado);
	
	PortatilesDTO portatilAsignado = new PortatilesDTO();
	
	DAOaDTO daoadto = new DAOaDTO();
	
	
	for (Portatil portatil : portatilRepositorio.findAll()) {
		
		if(portatil == alumnoSeleccionado.get().getPortatil_asignado()) {
			portatilAsignado = daoadto.portatiDAOaDTO(portatil);
		}
		else {
			mensaje = "El alumno no tiene un portatil asignado";
			miModelo.put("mensaje", mensaje);
		}
	}
	
	miModelo.put("portatilAsignado", portatilAsignado);
		
		return new ModelAndView("Confirmacion", "miModelo", miModelo);
	}
	
}

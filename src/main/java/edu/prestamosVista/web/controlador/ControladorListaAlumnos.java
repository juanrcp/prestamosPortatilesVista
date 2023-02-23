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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.prestamosVista.aplicacion.dal.AlumnoRepositorio;
import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dal.PortatilRepositorio;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DAOaDTO;
import edu.prestamosVista.aplicacion.dto.DTOUtiles;
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
	
	//Id elegida del Alumno para borrarlo 
	int idSeleccionada = 0;
	
	//Util para pasar informacion desde los formularios
	DTOUtiles dtoUtil = new DTOUtiles();

	

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
	
	model.addAttribute("dtoUtil", dtoUtil);
	
	miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
		
		return new ModelAndView("ListaAlumnos", "miModelo", miModelo);
	}
	
	@RequestMapping(value="/portatilDeAlumno", method = RequestMethod.POST)
	public ModelAndView portatilDeAlumno(@ModelAttribute ("dtoUtil") DTOUtiles dtoUtil) {
	
	DAOaDTO daoadto = new DAOaDTO();
	
	////Lista de portatiles para encontrar el portatil asignado. 
	//List<Portatil> listaPortatiles = new ArrayList<>();
	
	//Buscamos el alumno por su id y lo guardamos en el modelo
	Optional<Alumnos> alumnoSeleccionado = alumnoRepositorio.findById(dtoUtil.getIdSeleccionado());
	
	miModelo.put("alumnoSeleccionado", daoadto.alumnoDAOaDTO(alumnoSeleccionado.get()));
	
	PortatilesDTO portatilAsignado = new PortatilesDTO();
	
	
	
	for (Portatil portatil : portatilRepositorio.findAll()) {
		
		if(portatil.getNumero_identificador().equals(alumnoSeleccionado.get().getPortatil_asignado().getNumero_identificador())) {
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
	
	
	//Ir a confirmar borrado. Con la etiqueta PathVariable podemos obtener la id que le pasamos por URL
	@RequestMapping(value="/confirmarBorradoAlumnos/{id_alumno}")
	public String confirmarBorradoAlumnos(@PathVariable Integer id_alumno) {
			
		idSeleccionada = id_alumno;
			
		miModelo.put("idSeleccionada", idSeleccionada);
				
				
		miModelo.put("mensajeC", mensaje);
		//return new ModelAndView("BorrarAlumno", "miModelo", miModelo);
		return "BorrarAlumno";
	}
		
		//Metodo para borrar un alumno y generar mensaje de confirmacion. 
		@RequestMapping(value="/borrarAlumno")
		public ModelAndView borrarAlumno(@ModelAttribute("mensajeC") String mensajeC) {
			
			if(((String) miModelo.get("mensajeC")).toUpperCase() == "BORRAR") {
				
				alumnoRepositorio.deleteById((Integer) miModelo.get("idSeleccionada"));
				mensaje = "Alumno eliminado correctamente.";
				
			}
			else {
				mensaje = "No se ha realizado ningun cambio.";
			}
			
				
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
		}
		
	
}

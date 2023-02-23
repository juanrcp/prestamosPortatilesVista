package edu.prestamosVista.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.prestamosVista.aplicacion.dal.AlumnoRepositorio;
import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dal.PortatilRepositorio;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DAOaDTO;
import edu.prestamosVista.aplicacion.dto.DTOaDAO;

//Controlador que gestiona la comunicación entre modelo y vista de las altas de los alumnos
@Controller
public class ControladorAltaAlumnos {

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
	
	
	//Controlador de navegacion al formulario en el que introducimos un modelo con un nuevo alumno vacio
	@RequestMapping(value="/navegacionFormularioAltaAlumno")
	public String navegacionFormularioAltaAlumno(Model modelo) {
		logger.info("Navegamos al formulario de Alta");
		AlumnosDTO nuevoAlumnoDTO = new AlumnosDTO();		
		
	 	modelo.addAttribute("nuevoAlumno", nuevoAlumnoDTO);
		return "AltaAlumno";
	} 
		
	//Metodo post para añadir un nuevo alumno a la BBDD. 
	@RequestMapping(value="/altaAlumno", method = RequestMethod.POST)
	public ModelAndView altaAlumno(@ModelAttribute("nuevoAlumno") AlumnosDTO nuevoAlumnoDTO) {	
		
		DTOaDAO dtoadao = new DTOaDAO();
		
		List<String> listaPortatilesOcupados = new ArrayList<>();
		
		Portatil portatilLibre = new Portatil();
		
		//Hacemos una lista con los identificadores de los portatiles ocupados
		for(Alumnos alumnos: alumnoRepositorio.findAll()) {
			
			if(alumnos.getPortatil_asignado() != null)
				listaPortatilesOcupados.add(alumnos.getPortatil_asignado().getNumero_identificador());
		}
		
		//Revisamos si hay algun portatil libre comparandolos con los ocupados
		for(Portatil portatil: portatilRepositorio.findAll()) {
			if(!listaPortatilesOcupados.contains(portatil.getNumero_identificador())) {
				portatilLibre = portatil;
				mensaje = "Alumno guardado CON portatil asociado.";
				break;
			}
			else {
				portatilLibre = new Portatil();
				mensaje = "Alumno guardado SIN Portatil asociado (no hay portatiles libres).";
			}
		}
		
		//Asignamos el portatil libre al primer alumno
		nuevoAlumnoDTO.setPortatil_asignado(portatilLibre);
		
		//Guardamos al alumno con su partatil o no.
		alumnoRepositorio.save(dtoadao.alumnoDTOaDAO(nuevoAlumnoDTO));		
		

		System.out.println("Alumno Guardado.");
		miModelo.put("mensaje", mensaje);
		return new ModelAndView("Confirmacion", "miModelo", miModelo);
	}

}

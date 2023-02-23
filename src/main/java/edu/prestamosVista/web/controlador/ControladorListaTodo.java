package edu.prestamosVista.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import edu.prestamosVista.aplicacion.dto.DTOUtiles;
import edu.prestamosVista.aplicacion.dto.PortatilesDTO;

@Controller
public class ControladorListaTodo {
	
	//Lista de Alumnos
		List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
		
		//Lista de AlumnosDTO
		List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();
		
		//Creacion de modelo
		Map<String, Object> miModelo = new HashMap<String, Object>();


		//Inyectamos interfaz
		@Autowired
		AlumnoRepositorio alumnoRepositorio;
		
		@Autowired
		PortatilRepositorio portatilRepositorio;
		

		//Metodo que extrae a todos los alumnos y los muestra
		@RequestMapping(value="/mostrarTodo")
		public ModelAndView mostrarAlumnos() {
			
			//Lista con los resultados
			List<String> listaAsignaciones = new ArrayList<>();
			
			DAOaDTO daoadto = new DAOaDTO();
			
			PortatilesDTO portatilAsignado = new PortatilesDTO();
		
			for (Alumnos alumnos : alumnoRepositorio.findAll()) {
			
				if(alumnos.getPortatil_asignado() != null) {
					listaAsignaciones.add(daoadto.alumnoDAOaDTO(alumnos).toString() + " - Portatil asignado: " + daoadto.portatiDAOaDTO(alumnos.getPortatil_asignado()).toString());				
					
				}
				else {
					listaAsignaciones.add(daoadto.alumnoDAOaDTO(alumnos).toString() + " - Portatil asignado: SIN PORTATIL ASIGNADO.");
				}				
			}
		
			miModelo.put("listaAsignaciones", listaAsignaciones);
			
			return new ModelAndView("ListaTodo", "miModelo", miModelo);
		}
}

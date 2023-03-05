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

import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DAOaDTO;
import edu.prestamosVista.aplicacion.dto.DTOUtiles;
import edu.prestamosVista.aplicacion.dto.PortatilesDTO;
import edu.prestamosVista.web.servicios.Consultas;

//Controlador que gestiona la comunicación entre modelo y vista de la lista de los alumnos
@Controller
public class ControladorListaAlumnos {
	
	//Lista de AlumnosDTO
	List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
	
	//Mensajes de confirmación
	String mensaje = null;
	
	//Util para pasar informacion desde los formularios
	DTOUtiles dtoUtil = new DTOUtiles();

	//Inyeccion de las consultas
	@Autowired
	Consultas consultas;
	
	//Inyeccion del Controlador del login para controlar accesos y sesion
	@Autowired
	ControladorLogin sesion;
	

	//Metodo que extrae a todos los alumnos y los muestra
	@RequestMapping(value="/mostrarAlumnos")
	public ModelAndView mostrarAlumnos(Model model) {
		
		try {
			
			//Controlamos sesion inyectandole el modelo con el rol
			if(sesion.miModelo.get("rol").equals("GESTOR")) {
				
				//Lista de alumnos AUX la cual reiniciaremos cada vez que ejecutamos el metodo. 
				List<AlumnosDTO> listaAlumnosDTOaux = new ArrayList<>();
				DAOaDTO daoadto = new DAOaDTO();
			
				for (Alumnos alumnos : consultas.listarTodosAlumnos()) {
				
					listaAlumnosDTOaux.add(daoadto.alumnoDAOaDTO(alumnos));		
				}
				
				//Guardamos la lista dentro de la lista final.
				listaAlumnosDTO = listaAlumnosDTOaux;
				
				//listaAlumnosDTOaux.clear();
			
				model.addAttribute("dtoUtil", dtoUtil);
			
				miModelo.put("listaAlumnosDTO", listaAlumnosDTO);
				
				//Guardamos el rol para el contol del boton de cerrar sesion
				miModelo.put("rol", sesion.miModelo.get("rol"));
				
				return new ModelAndView("ListaAlumnos", "miModelo", miModelo);
				
			}
			else {
				
				mensaje = "ACCESO DENEGADO: No tienes permiso para entrar en este apartado";
				sesion.miModelo.put("mensaje", mensaje);
				return new ModelAndView("Confirmacion", "miModelo", sesion.miModelo);
				
			}
			
		} catch (Exception e) {

			mensaje = "ACCESO DENEGADO: No tienes permiso para entrar en este apartado";
			sesion.miModelo.put("mensaje", mensaje);
			return new ModelAndView("Confirmacion", "miModelo", sesion.miModelo);
		}
	}
	
	
	//Metodo para buscar portatil mediante el ID del alumno
	@RequestMapping(value="/portatilDeAlumno", method = RequestMethod.POST)
	public ModelAndView portatilDeAlumno(@ModelAttribute ("dtoUtil") DTOUtiles dtoUtil) {
	
		try {
			
			DAOaDTO daoadto = new DAOaDTO();
			
			//Buscamos el alumno por su id y lo guardamos en el modelo
			//Optional<Alumnos> alumnoSeleccionado = alumnoRepositorio.findById(dtoUtil.getIdSeleccionado());
			Optional<Alumnos> alumnoSeleccionado = consultas.buscaAlumno(dtoUtil.getIdSeleccionado());
			miModelo.put("alumnoSeleccionado", daoadto.alumnoDAOaDTO(alumnoSeleccionado.get()));
		
			//Aqui guardamos el potatil que tenga asignado.
			PortatilesDTO portatilAsignado = new PortatilesDTO();
		
		
			for (Portatil portatil : consultas.listarTodosPortatiles()) {
			
				//Buscamos el portatil cuya referencia sea correspondiente a la del portatil asignado al alumno
				if(portatil.getNumero_identificador().equals(alumnoSeleccionado.get().getPortatil_asignado().getNumero_identificador())) {
					portatilAsignado = daoadto.portatiDAOaDTO(portatil);
				}
				else {
					mensaje = "El alumno no tiene un portatil asignado";
					miModelo.put("mensaje", mensaje);
				}
			}
		
			miModelo.put("portatilAsignado", portatilAsignado);
			
			return new ModelAndView("Resultados", "miModelo", miModelo);
			
		
		} catch (Exception e) {
			
			mensaje = "¡ERROR! El valor introducido no es valido o el alumno no tiene portatil asignado. Vuelva al Inicio.";
			
			miModelo.put("mensaje", mensaje);
			
			return new ModelAndView("Confirmacion", "miModelo", miModelo);

		}
		
	}	
}

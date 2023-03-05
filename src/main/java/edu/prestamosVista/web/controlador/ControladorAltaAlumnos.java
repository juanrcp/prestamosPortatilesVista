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

import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DTOaDAO;
import edu.prestamosVista.web.servicios.Consultas;

//Controlador que gestiona la comunicación entre modelo y vista de las altas de los alumnos
@Controller
public class ControladorAltaAlumnos {

	protected final Log logger = LogFactory.getLog(getClass());
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
	
	//Mensajes de confirmación
	String mensaje = null;
	
	
	//Inyectamos consultas
	@Autowired
	Consultas consultas;
	
	//Inyeccion del Controlador del login para controlar accesos y sesion
	@Autowired
	ControladorLogin sesion;
	
	
	//Controlador de navegacion al formulario en el que introducimos un modelo con un nuevo alumno vacio
	@RequestMapping(value="/navegacionFormularioAltaAlumno")
	public ModelAndView navegacionFormularioAltaAlumno(Model modelo) {
		
		try {
			
			//Controlamos sesion inyectandole el modelo con el rol
			if(sesion.miModelo.get("rol").equals("GESTOR")) {
			
				logger.info("Navegamos al formulario de Alta");
				AlumnosDTO nuevoAlumnoDTO = new AlumnosDTO();	
				
				//Guardamos el rol para el contol del boton de cerrar sesion
				modelo.addAttribute("rol", sesion.miModelo.get("rol"));
							
				modelo.addAttribute("nuevoAlumno", nuevoAlumnoDTO);
				return new ModelAndView("AltaAlumno", "miModelo", modelo);
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
		
	//Metodo post para añadir un nuevo alumno a la BBDD. 
	@RequestMapping(value="/altaAlumno", method = RequestMethod.POST)
	public ModelAndView altaAlumno(@ModelAttribute("nuevoAlumno") AlumnosDTO nuevoAlumnoDTO) {	
		
		try {
			
			DTOaDAO dtoadao = new DTOaDAO();
			
			//Lista de portatiles acupados
			List<String> listaPortatilesOcupados = new ArrayList<>();
			
			//Portatil libre
			Portatil portatilLibre = new Portatil();
			
			//Hacemos una lista con los identificadores de los portatiles ocupados
			for(Alumnos alumnos: consultas.listarTodosAlumnos()) {
				
				if(alumnos.getPortatil_asignado() != null)
					listaPortatilesOcupados.add(alumnos.getPortatil_asignado().getNumero_identificador());
			}
			
			//Revisamos si hay algun portatil libre comparandolos con los ocupados
			for(Portatil portatil: consultas.listarTodosPortatiles()) {
				
				if(!listaPortatilesOcupados.contains(portatil.getNumero_identificador())) {
					portatilLibre = portatil;
					mensaje = "Alumno guardado CON portatil asociado.";
					break;
				}
				else {
					portatilLibre = null;
					mensaje = "Alumno guardado SIN Portatil asociado (no hay portatiles libres).";
				}
			}
			
			//Asignamos el portatil libre al primer alumno
			nuevoAlumnoDTO.setPortatil_asignado(portatilLibre);
			
			//Guardamos al alumno con su partatil o no.
			consultas.guardaAlumno(dtoadao.alumnoDTOaDAO(nuevoAlumnoDTO));
			

			System.out.println("Alumno Guardado.");
			miModelo.put("mensaje", mensaje);
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
			
		} catch (Exception e) {

			mensaje = "¡ERROR! Se ha producido un error. Acción NO realizada. Vuelva al Inicio.";
			
			miModelo.put("mensaje", mensaje);
			
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
			
		}	
	}
}

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DAOaDTO;
import edu.prestamosVista.aplicacion.dto.DTOUtiles;
import edu.prestamosVista.aplicacion.dto.PortatilesDTO;
import edu.prestamosVista.web.servicios.Consultas;

@Controller
public class ControladorListaPortatiles {

protected final Log logger = LogFactory.getLog(getClass());
	
	//Lista de AlumnosDTO
	List<PortatilesDTO> listaPortatilesDTO = new ArrayList<PortatilesDTO>();
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
	
	//Util para pasar informacion desde los formularios
	DTOUtiles dtoUtil = new DTOUtiles();
	
	//Mensaje de confirmacion
	String mensaje = null;


	//Inyectamos consultas	
	@Autowired
	Consultas consultas;
	

	//Metodo que extrae a todos los portatiles y mostrarlos
	@RequestMapping(value="/mostrarPortatiles")
	public ModelAndView mostrarPortatiles(Model model) {
		
		//Lista de alumnos AUX la cual reiniciaremos cada vez que ejecutamos el metodo. 
		List<PortatilesDTO> listaPortatilesDTOaux = new ArrayList<PortatilesDTO>();
		DAOaDTO daoadto = new DAOaDTO();
	
		for (Portatil portatil : consultas.listarTodosPortatiles()) {
		
			listaPortatilesDTOaux.add(daoadto.portatiDAOaDTO(portatil));		
		}
		
		//Guardamos la lista dentro de la lista final.
		listaPortatilesDTO = listaPortatilesDTOaux;
	
		model.addAttribute("dtoUtil", dtoUtil);
	
		miModelo.put("listaPortatilesDTO", listaPortatilesDTO);
		
		return new ModelAndView("ListaPortatiles", "miModelo", miModelo);
	}
	
	
	//Metodo para mostrar el alumno que tiene el portatil X segun su codeigo de registro.
	@RequestMapping(value="/alumnodePortatil", method = RequestMethod.POST)
	public ModelAndView portatilDeAlumno(@ModelAttribute ("dtoUtil") DTOUtiles dtoUtil) {
		
		try {
			
			DAOaDTO daoadto = new DAOaDTO();
			
			//Buscamos el portatil por su codigo y lo guardamos en el modelo
			//Optional<Portatil> portatilSeleccionado = portatilRepositorio.findById(dtoUtil.getMensajeC());
			Optional<Portatil> portatilSeleccionado = consultas.buscaPortatil(dtoUtil.getMensajeC());
			
			miModelo.put("alumnoSeleccionado", daoadto.portatiDAOaDTO(portatilSeleccionado.get()));
			
			//Alumno poseedor del portatil
			AlumnosDTO alumnoPoseedor = new AlumnosDTO();		
			
			//Buscamos entre todos los alumnos el que tenga el codigo de referencia de portatil igual al que le hemos dado
			for (Alumnos alumno : consultas.listarTodosAlumnos()) {
				
				if(alumno.getPortatil_asignado().getNumero_identificador().equals(portatilSeleccionado.get().getNumero_identificador())) {
					alumnoPoseedor = daoadto.alumnoDAOaDTO(alumno);
				}
				else {
					mensaje = "El portatil no tiene un alumno asignado";
					miModelo.put("mensaje", mensaje);
				}
			}
			
			miModelo.put("alumnoPoseedor", alumnoPoseedor);
				
				return new ModelAndView("Resultados", "miModelo", miModelo);
			
		} catch (Exception e) {

			mensaje = "¡ERROR! El valor introducido no es valido. Vuelva al Inicio.";
			
			miModelo.put("mensaje", mensaje);
			
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
		}	
	}
}

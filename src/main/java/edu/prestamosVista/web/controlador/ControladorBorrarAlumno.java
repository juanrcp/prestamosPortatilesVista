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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.prestamosVista.aplicacion.dal.AlumnoRepositorio;
import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.PortatilRepositorio;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DTOUtiles;

//Controlador para ir a BorrarAlumno y borrarlo
@Controller
public class ControladorBorrarAlumno {
	
	
	protected final Log logger = LogFactory.getLog(getClass());
	
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
	
	
	//Ir a confirmar borrado en BorrarAlumno. Con la etiqueta PathVariable podemos obtener la id que le pasamos por URL
	@RequestMapping(value="/confirmarBorradoAlumnos/{id_alumno}")
	public String confirmarBorradoAlumnos(@PathVariable Integer id_alumno, Model model) {
		
		logger.info("Navegamos a la confirmacion del borrado.");		
		
		idSeleccionada = id_alumno;			
		miModelo.put("idSeleccionada", idSeleccionada);
		
		model.addAttribute("dtoUtil", dtoUtil);

		return "BorrarAlumno";
	}
			
	//Metodo para borrar un alumno y generar mensaje de confirmacion. 
	@RequestMapping(value="/confirmarBorradoAlumnos/borraAlumno", method = RequestMethod.POST)
	public ModelAndView borraAlumno(@ModelAttribute("dtoUtil") DTOUtiles dtoUtil) {
				
		if(dtoUtil.getMensajeC().toUpperCase().equals("BORRAR")) {
					
			alumnoRepositorio.deleteById((Integer) miModelo.get("idSeleccionada"));
			mensaje = "Alumno eliminado correctamente.";
					
		}
		else {
			mensaje = "No se ha realizado ningun cambio.";
			miModelo.put("mensaje", mensaje);
			
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
		}
				
		miModelo.put("mensaje", mensaje);
					
		return new ModelAndView("Confirmacion", "miModelo", miModelo);
	}

}

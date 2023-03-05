package edu.prestamosVista.web.controlador;

import java.util.HashMap;
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

import edu.prestamosVista.aplicacion.dto.DTOaDAO;
import edu.prestamosVista.aplicacion.dto.PortatilesDTO;
import edu.prestamosVista.web.servicios.Consultas;

//Controlador que gestiona la comunicación entre modelo y vista de las altas de los portatiles
@Controller
public class ControladorAltasPortatil {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
		
	//Mensajes de confirmación
	String mensaje = null;
	
	
	//Inyeccion de consulta
	@Autowired
	Consultas consultas;
	
	//Inyeccion del Controlador del login para controlar accesos y sesion
	@Autowired
	ControladorLogin sesion;
	
	
	//Controlador de navegacion al formulario en el que introducimos un modelo con un nuevo portatil vacio
	@RequestMapping(value="/navegacionFormularioAltaPortatil")
	public ModelAndView navegacionFormularioAltaPortatil(Model modelo) {
		
		try {
			
			//Controlamos sesion inyectandole el modelo con el rol
			if(sesion.miModelo.get("rol").equals("GESTOR")) {
				
				logger.info("Navegamos al formulario de Alta");
				PortatilesDTO nuevoPortatilDTO = new PortatilesDTO();		
						
			 	modelo.addAttribute("nuevoPortatil", nuevoPortatilDTO);
				return new ModelAndView("AltaPortatil", "miModelo", modelo);
				
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
				
	//Metodo post para añadir un nuevo portatil a la BBDD. 
	@RequestMapping(value="/altaPortatil", method = RequestMethod.POST)
	public ModelAndView altaPortatil(@ModelAttribute("nuevoPortatil") PortatilesDTO nuevoPortatilDTO) {	
		
		try {
			
			DTOaDAO dtoadao = new DTOaDAO();
			
			//Guardamos el portatil
			consultas.guardaPortatil(dtoadao.portatiDTOaDAO(nuevoPortatilDTO));
						
			mensaje = "Portatil Guardado";

			System.out.println("Portatil Guardado.");
			miModelo.put("mensaje", mensaje);
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
			
			
		} catch (Exception e) {

			mensaje = "¡ERROR! Se ha producido un error. Acción NO realizada. Vuelva al Inicio.";
			
			miModelo.put("mensaje", mensaje);
			
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
			
		}
	}
}

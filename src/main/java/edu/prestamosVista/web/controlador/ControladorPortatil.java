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

import edu.prestamosVista.aplicacion.dal.PortatilRepositorio;
import edu.prestamosVista.aplicacion.dto.DTOaDAO;
import edu.prestamosVista.aplicacion.dto.PortatilesDTO;

//Controlador que gestiona la comunicación entre modelo y vista
@Controller
public class ControladorPortatil {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
		
	//Mensajes de confirmación
	String mensaje = null;
	
	@Autowired
	PortatilRepositorio portatilRopositorio;
	
	//Controlador de navegacion al formulario en el que introducimos un modelo con un nuevo portatil vacio
	@RequestMapping(value="/navegacionFormularioAltaPortatil")
	public String navegacionFormularioAltaPortatil(Model modelo) {
		logger.info("Navegamos al formulario de Alta");
		PortatilesDTO nuevoPortatilDTO = new PortatilesDTO();		
				
	 	modelo.addAttribute("nuevoPortatil", nuevoPortatilDTO);
		return "AltaPortatil";
	} 
				
	//Metodo post para añadir un nuevo portatil a la BBDD. 
	@RequestMapping(value="/altaPortatil", method = RequestMethod.POST)
	public ModelAndView altaPortatil(@ModelAttribute("nuevoPortatil") PortatilesDTO nuevoPortatilDTO) {	
				
		DTOaDAO dtoadao = new DTOaDAO();
						
		portatilRopositorio.save(dtoadao.portatiDTOaDAO(nuevoPortatilDTO));
					
		mensaje = "Portatil Guardado";

		System.out.println("Portatil Guardado.");
		miModelo.put("mensaje", mensaje);
		return new ModelAndView("Confirmacion", "miModelo", miModelo);
	}

}

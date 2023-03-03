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
import edu.prestamosVista.aplicacion.dto.UsuariosDTO;
import edu.prestamosVista.web.servicios.Consultas;

/**
 * Controlador para el alta de usuarios
 * @author Juan Ramon Canto
 *
 */
@Controller
public class ControladorAltaUsuario {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
		
	//Mensajes de confirmación
	String mensaje = null;
	
	//Inyeccion de consultas
	@Autowired
	Consultas consulta;
	
	/**
	 * Controlador de navegacion al formulario en el que introducimos un modelo con un nuevo alumno vacio
	 * @param modelo 
	 * @return Un string que forma la URL de la vista a la que navegamos
	 */
	@RequestMapping(value="/navegacionRegistroUsuario")
	public String navegacionRegistroUsuario(Model modelo) {
		
		logger.info("Navegamos al registro de usuario");
		UsuariosDTO nuevoUsuarioDTO = new UsuariosDTO();		
			
	 	modelo.addAttribute("nuevoUsuario", nuevoUsuarioDTO);
		return "AltaUsuario";
	}
	
	
	/**
	 * Metodo post para añadir un nuevo usuario a la BBDD. 
	 * @param nuevoUsuarioDTO
	 * @return Devulve la vista deseada junto con el modelo
	 */
	@RequestMapping(value="/altaUsuario", method = RequestMethod.POST)
	public ModelAndView altaUsuario(@ModelAttribute("nuevoUsuario") UsuariosDTO nuevoUsuarioDTO) {	
			
		try {
				
			DTOaDAO dtoadao = new DTOaDAO();
				
			//Guardamos al usuario.
			consulta.registraUsuario(dtoadao.usuarioDTOaDAO(nuevoUsuarioDTO));
			

			System.out.println("Usuario Registrado.");
			miModelo.put("mensaje", mensaje);
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
				
		} catch (Exception e) {

			mensaje = "¡ERROR! Se ha producido un error. Acción NO realizada. Vuelva al Inicio.";
				
			miModelo.put("mensaje", mensaje);
				
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
				
		}	
	}

}

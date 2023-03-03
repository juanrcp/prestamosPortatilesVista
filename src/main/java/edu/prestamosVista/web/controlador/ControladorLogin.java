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
 * Clase controlador del la vista login 
 * @author Juan Ramon Canto
 *
 */
@Controller
public class ControladorLogin {

	protected final Log logger = LogFactory.getLog(getClass());
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
			
	//Mensajes de confirmación
	String mensaje = null;
	
	//Inyeccion de consultas
	@Autowired
	Consultas consulta;
	
	/**
	 * Controlador de navegacion al login en el que introducimos un modelo para que el usuario pueda acceder. 
	 * @param modelo 
	 * @return Un string que forma la URL de la vista a la que navegamos
	 */
	@RequestMapping(value="/login")
	public String navegacionLogin(Model modelo) {
		
		logger.info("Navegamos al Login");
		UsuariosDTO usuarioDTO = new UsuariosDTO();		
			
	 	modelo.addAttribute("usuario", usuarioDTO);
		return "Login";
	}
	
	
	/**
	 * Metodo post para uevo usuario a la BBDD. 
	 * @param nuevoUsuarioDTO
	 * @return
	 */
	@RequestMapping(value="/accesoLogin", method = RequestMethod.POST)
	public ModelAndView accesoLogin(@ModelAttribute("usuario") UsuariosDTO usuarioDTO) {	
			
		try {
				
			DTOaDAO dtoadao = new DTOaDAO();
				
			//Guardamos al usuario.
			//consulta.registraUsuario(dtoadao.usuarioDTOaDAO(usuarioDTO));
			

			System.out.println("Usuario Registrado.");
			//miModelo.put("mensaje", mensaje);
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
				
		} catch (Exception e) {

			mensaje = "¡ERROR! Se ha producido un error. Acción NO realizada. Vuelva al Inicio.";
				
			miModelo.put("mensaje", mensaje);
				
			return new ModelAndView("Confirmacion", "miModelo", miModelo);
				
		}	
	}
	//hay que terminar el login por aqui 
	//https://somospnt.com/blog/162-maneja-tus-usuarios-y-sus-roles-con-spring-security
	//https://codigosdeprogramacion.com/cursos/?lesson=21-privilegios-y-roles-de-usuarios
}

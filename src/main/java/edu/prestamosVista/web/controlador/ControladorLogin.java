package edu.prestamosVista.web.controlador;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class ControladorLogin extends HttpServlet{

	protected final Log logger = LogFactory.getLog(getClass());
	
	//Creacion de modelo que usaremos entre otras cosas para controlar la sesion y gestionar el rol
	Map<String, Object> miModelo = new HashMap<String, Object>();
			
	//Mensajes de confirmación
	String mensaje = null;

	//Inyeccion de consultas
	@Autowired
	Consultas consulta;
	
	//PROPIEDADES
	public Map<String, Object> getMiModelo() {
		return miModelo;
	}


	public void setMiModelo(Map<String, Object> miModelo) {
		this.miModelo = miModelo;
	}

	
	//METODOS
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
			if(consulta.buscaUsuario(usuarioDTO) != null) {
				
				//Buscamos el usuario y guardamos su rol en el modelo
				miModelo.put("rol", consulta.buscaUsuario(usuarioDTO).getRol_Usuario());
				
				System.out.println("Usuario Correcto.");
				
				mensaje = "Usuario Correcto.";
				
				miModelo.put("mensaje", mensaje);
				
		
				return new ModelAndView("Confirmacion", "miModelo", miModelo);
			}
			else {
			
				String denegado = "Usuario Incorrecto.";
				miModelo.put("denegado", denegado);
				return new ModelAndView("Login", "miModelo", miModelo);
			}

				
		} catch (Exception e) {

			mensaje = "¡ERROR! Se ha producido un error. Acción NO realizada. Vuelva al Inicio.";
				
			miModelo.put("mensaje", mensaje);
				
			return new ModelAndView("Login", "miModelo", miModelo);
				
		}	
	}
	
	
	@RequestMapping(value="/Logout")
	public ModelAndView cerrarSesion() {	
		
		miModelo.clear();
		
		mensaje = "Sesion Cerrada.";
		
		miModelo.put("mensaje", mensaje);
		
		return new ModelAndView("Confirmacion", "miModelo", miModelo);
		
	}
}

package edu.prestamosVista.web.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.prestamosVista.web.servicios.Consultas;

/**
 * Clase controlador del la vista login 
 * @author Juan Ramon Canto
 *
 */
@Controller
public class ControladorLogin {
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
			
	//Mensajes de confirmación
	String mensaje = null;
	
	//Inyeccion de consultas
	@Autowired
	Consultas consulta;
	
	
	//hay que terminar el login por aqui 
	//https://somospnt.com/blog/162-maneja-tus-usuarios-y-sus-roles-con-spring-security
	//https://codigosdeprogramacion.com/cursos/?lesson=21-privilegios-y-roles-de-usuarios
}

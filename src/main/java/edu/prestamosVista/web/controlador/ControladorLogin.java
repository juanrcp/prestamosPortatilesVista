package edu.prestamosVista.web.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import edu.prestamosVista.web.servicios.Consultas;

public class ControladorLogin {
	
	//Creacion de modelo
		Map<String, Object> miModelo = new HashMap<String, Object>();
			
		//Mensajes de confirmación
		String mensaje = null;
		
		@Autowired
		Consultas consulta;
	
}

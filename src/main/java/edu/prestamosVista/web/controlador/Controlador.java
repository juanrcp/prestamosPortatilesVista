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

import edu.prestamosVista.aplicacion.dal.AlumnoRepositorio;
import edu.prestamosVista.aplicacion.dal.Alumnos;

//Controlador que gestiona la comunicación entre modelo y vista
@Controller
public class Controlador {

	protected final Log logger = LogFactory.getLog(getClass());
	
	//Lista de Alumnos
	List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
	
	//Creacion de modelo
	Map<String, Object> miModelo = new HashMap<String, Object>();
	
	//Inyectamos interfaz
	@Autowired
	AlumnoRepositorio alumnoInterfaz;
		
		
	//Metodo post para añadir un nuevo alumno a la BBDD. 
	@RequestMapping(value="/pruebaPost", method = RequestMethod.POST)
	public ModelAndView pruebaPOST(@ModelAttribute("UsuarioNuevo") Alumnos nuevoAlumno) {	
			
		alumnoInterfaz.save(nuevoAlumno);
			
		//miModelo.put("listaAlumnos", alu);

						
		return new ModelAndView("index", "miModelo", miModelo);
	}
	

}

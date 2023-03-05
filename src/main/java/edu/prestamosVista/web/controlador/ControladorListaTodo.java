package edu.prestamosVista.web.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dto.AlumnosDTO;
import edu.prestamosVista.aplicacion.dto.DAOaDTO;
import edu.prestamosVista.web.servicios.Consultas;

@Controller
public class ControladorListaTodo {
	
	//Lista de Alumnos
		List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
		
		//Lista de AlumnosDTO
		List<AlumnosDTO> listaAlumnosDTO = new ArrayList<AlumnosDTO>();
		
		//Creacion de modelo
		Map<String, Object> miModelo = new HashMap<String, Object>();


		//Inyectamos consultas		
		@Autowired
		Consultas consulta;
		
		//Inyeccion del Controlador del login para controlar accesos y sesion
		@Autowired
		ControladorLogin sesion;
		

		//Metodo que extrae a todos los alumnos y los muestra
		@RequestMapping(value="/mostrarTodo")
		public ModelAndView mostrarAlumnos() {
			
			try {
				
				//Controlamos sesion inyectandole el modelo con el rol
				if(sesion.miModelo.get("rol").equals("ADMINISTRADOR")) {
					
					//Lista con los resultados
					List<String> listaAsignaciones = new ArrayList<>();
					
					DAOaDTO daoadto = new DAOaDTO();
				
					for (Alumnos alumnos : consulta.listarTodosAlumnos()) {
					
						if(alumnos.getPortatil_asignado() != null) {
							listaAsignaciones.add(daoadto.alumnoDAOaDTO(alumnos).toString() + " - PORTATIL ASIGNADO: " + daoadto.portatiDAOaDTO(alumnos.getPortatil_asignado()).toString());				
							
						}
						else {
							listaAsignaciones.add(daoadto.alumnoDAOaDTO(alumnos).toString() + " - PORTATIL ASIGNADO: SIN PORTATIL ASIGNADO.");
						}				
					}
				
					miModelo.put("listaAsignaciones", listaAsignaciones);
					
					//Guardamos el rol para el contol del boton de cerrar sesion
					miModelo.put("rol", sesion.miModelo.get("rol"));
					
					return new ModelAndView("ListaTodo", "miModelo", miModelo);
					
				}
				else {
					
					String mensaje = "ACCESO DENEGADO: No tienes permiso para entrar en este apartado";
					sesion.miModelo.put("mensaje", mensaje);
					return new ModelAndView("Confirmacion", "miModelo", sesion.miModelo);
					
				}
				
			} catch (Exception e) {

				String mensaje = "ACCESO DENEGADO: No tienes permiso para entrar en este apartado";
				sesion.miModelo.put("mensaje", mensaje);
				return new ModelAndView("Confirmacion", "miModelo", sesion.miModelo);
			}	
		}
}

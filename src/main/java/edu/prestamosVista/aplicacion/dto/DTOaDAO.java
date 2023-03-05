package edu.prestamosVista.aplicacion.dto;


import java.util.Date;

import org.springframework.stereotype.Service;

import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dal.Usuarios;


//Servicio con la clase para convertir los DTO a DAO
@Service
public class DTOaDAO {

	//Metodo para convertir a los alumnosDTO a DAO
	public Alumnos alumnoDTOaDAO(AlumnosDTO alum) {
		
		//Obtenemos fecha para actualizar el metadato
		Date fecha = new Date();
		 
        System.out.println(fecha); 
		
		return new Alumnos(alum.getNombre_alumno(), alum.getTelefono_alumno(), alum.getPortatil_asignado(), ("Alumno-" + fecha));
	}
		
	//Metodo para convertir a los portatilesDTO a DAO
	public Portatil portatiDTOaDAO(PortatilesDTO port) {
		
		//Obtenemos fecha para actualizar el metadato
		Date fecha = new Date();
				 
		System.out.println(fecha);
		
		return new Portatil(port.getNumero_identificador(), port.getMarca(), port.getModelo(), ("Portatil-" + fecha));
		
	}
	
	
	//Metodo para convertir a los portatilesDTO a DAO
	public Usuarios usuarioDTOaDAO(UsuariosDTO usuarioDTO) {
			
		//Obtenemos fecha para actualizar el metadato
		Date fecha = new Date();
					 
		System.out.println(fecha);
			
		return new Usuarios(usuarioDTO.getNombre_Usuario(), usuarioDTO.getClave_Usuario(), usuarioDTO.getRol_usuario(), ("Usuario-" + fecha));
			
	}
}

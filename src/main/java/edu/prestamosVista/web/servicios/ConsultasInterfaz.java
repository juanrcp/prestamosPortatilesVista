package edu.prestamosVista.web.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.prestamosVista.aplicacion.dal.Alumnos;
import edu.prestamosVista.aplicacion.dal.Portatil;
import edu.prestamosVista.aplicacion.dal.Usuarios;
import edu.prestamosVista.aplicacion.dto.UsuariosDTO;

/**
 * Servicio con la interfaz de las consultas
 * @author Juan Ramón Canto Pachón
 *
 */
@Service
public interface ConsultasInterfaz {
		
	//Metodo para hacer un listado de todos los alumnos
	public List<Alumnos> listarTodosAlumnos();
	
	//Metodo para guardar alumnos
	public void guardaAlumno(Alumnos nuevoAlumno);
	
	
	//Metodo para buscar un alumno mediante su ID
	public Optional<Alumnos> buscaAlumno(int idAlumno);
	
	
	//Metodo para consultar todos los portatiles
	public List<Portatil> listarTodosPortatiles();
	
	//Metodo para buscar un portatil mediante su codigo de identificacion. 
	public Optional<Portatil> buscaPortatil(String idPortatil);
	
	
	//Metodo para guardar alumnos
	public void guardaPortatil(Portatil nuevoPortatil);
	
	//Metodo para borrar portatiles
	public void borraAlumnoporID(int idPortatil);
	
	//Metodo para buscar a un usuario para el login
	public Usuarios buscaUsuario(UsuariosDTO usuario);

}

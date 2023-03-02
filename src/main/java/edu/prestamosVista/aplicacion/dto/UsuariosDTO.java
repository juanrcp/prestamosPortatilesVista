package edu.prestamosVista.aplicacion.dto;

import org.springframework.stereotype.Service;

/**
 * Servicio con la clase DTO equivalente a los Usuarios
 * @author Juan Ramon Canto
 *
 */
//Servicio con la definicion del DTO de los Usuarios
@Service
public class UsuariosDTO {

	//ATRIBUTOS
	
	private long id_Usuario;
	
	private String nombre_Usuario;
	
	private String clave_Usuario;
	
	private String rol_usuario;

	
	//PROPIEDADES
	
	public long getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(long id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getNombre_Usuario() {
		return nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}

	public String getClave_Usuario() {
		return clave_Usuario;
	}

	public void setClave_Usuario(String clave_Usuario) {
		this.clave_Usuario = clave_Usuario;
	}

	public String getRol_usuario() {
		return rol_usuario;
	}

	public void setRol_usuario(String rol_usuario) {
		this.rol_usuario = rol_usuario;
	}

	
	//CONSTRUCTORES	
	
	public UsuariosDTO(String nombre_Usuario, String clave_Usuario, String rol_usuario) {
		super();
		this.id_Usuario = id_Usuario;
		this.nombre_Usuario = nombre_Usuario;
		this.clave_Usuario = clave_Usuario;
		this.rol_usuario = rol_usuario;
	}

	public UsuariosDTO() {
		super();
	}
	
}

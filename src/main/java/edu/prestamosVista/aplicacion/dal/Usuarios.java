package edu.prestamosVista.aplicacion.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase con la entidad que guarda a los Usuarios
 * @author Juan Ramon Canto
 *
 */
@Entity
@Table(name = "usuarios", schema = "dlk_acceso")
public class Usuarios {

	/**
	 * ATRIBUTOS
	 */
	@Id
	@Column(name = "id_Usuario")
	long id_Usuario;
	
	@Column(name = "nombre_Usuario")
	String nombre_Usuario;
	
	@Column(name = "clave_Usuario")
	String clave_Usuario;
	
	@Column(name = "rol_Usuario")
	String rol_Usuario;
	
	@Column(name = "meta_Usuario")
	String meta_Usuario;

	
	//PROPIEDADES
	
	public Usuarios() {
		super();
	}

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

	public String getRol_Usuario() {
		return rol_Usuario;
	}

	public void setRol_Usuario(String rol_Usuario) {
		this.rol_Usuario = rol_Usuario;
	}

	public String getMeta_Usuario() {
		return meta_Usuario;
	}

	public void setMeta_Usuario(String meta_Usuario) {
		this.meta_Usuario = meta_Usuario;
	}


	
	//CONSTRUCTORES
	
	public Usuarios(long id_Usuario, String nombre_Usuario, String clave_Usuario, String rol_Usuario,
			String meta_Usuario) {
		super();
		this.id_Usuario = id_Usuario;
		this.nombre_Usuario = nombre_Usuario;
		this.clave_Usuario = clave_Usuario;
		this.rol_Usuario = rol_Usuario;
		this.meta_Usuario = meta_Usuario;
	}	
	
	public Usuarios(String nombre_Usuario, String clave_Usuario, String rol_Usuario,
			String meta_Usuario) {
		super();
		this.id_Usuario = this.id_Usuario;
		this.nombre_Usuario = nombre_Usuario;
		this.clave_Usuario = clave_Usuario;
		this.rol_Usuario = rol_Usuario;
		this.meta_Usuario = meta_Usuario;
	}	
}

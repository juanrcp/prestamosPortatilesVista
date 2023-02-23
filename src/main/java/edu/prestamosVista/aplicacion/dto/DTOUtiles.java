package edu.prestamosVista.aplicacion.dto;

import org.springframework.stereotype.Service;

//Clase DTOUtiles la cual nos sierve para poder tranferir desde los formularios al controlador informacion
//de diferentes tipos
@Service
public class DTOUtiles {
	
	//ATRIBUTOS
	
	int idSeleccionado ;
	
	String mensajeC;

	
	//METODOS
	
	public int getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(int idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public String getMensajeC() {
		return mensajeC;
	}

	public void setMensajeC(String mensajeC) {
		this.mensajeC = mensajeC;
	}
	
	
	//CONSTRUCTORES

	public DTOUtiles(int idSeleccionado, String mensajeC) {
		super();
		this.idSeleccionado = idSeleccionado;
		this.mensajeC = mensajeC;
	}


	public DTOUtiles(int idSeleccionado) {
		super();
		this.idSeleccionado = idSeleccionado;
	}

	public DTOUtiles(String mensajeC) {
		super();
		this.mensajeC = mensajeC;
	}
	
	public DTOUtiles() {
		super();
	}
		

}

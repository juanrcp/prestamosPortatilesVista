package edu.prestamosVista.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Interfaz de alumnos que implementa "CrudRepository" la cual le permite heredar todos los metodos tipicos del un CRUD
@Repository
public interface AlumnoRepositorio extends CrudRepository<Alumnos, Integer>{

}

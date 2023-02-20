package edu.prestamosVista.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Interfaz de portatiles que implementa "CrudRepository" la cual le permite heredar todos los metodos tipicos del un CRUD
@Repository
public interface PortatilRepositorio extends CrudRepository<Portatil, String>{

}

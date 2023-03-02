package edu.prestamosVista.aplicacion.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la entidad usuario con los metodos del CRUD
 * @author Juan Ramon Canto
 *
 */
@Repository
public interface UsuariosRepositorio extends CrudRepository<Usuarios, Long>{

}

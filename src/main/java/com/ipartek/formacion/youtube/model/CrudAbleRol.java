package com.ipartek.formacion.youtube.model;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;

/**
 * Interfaz para especificar los metodos de <b>CRUD</b>:
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * 
 * @author Curso
 *
 */
public interface CrudAbleRol<P> {

	// Create
	boolean insert(P pojo) throws Exception;

	// Read
	/**
	 * Recupera todos los pojo
	 * 
	 * @return si no existe resultados retorna Lista vacia, no null
	 */
	List<P> getAll() throws Exception;

	/**
	 * Buscamos un pojo por su identificador
	 * 
	 * @param id
	 * @return VideoYoutube si lo encuentra, null si no lo encuentra
	 */
	// Upadte
	boolean update(P pojo) throws Exception;

	// Delete

	boolean delete(String l) throws Exception;

	P getById(long id) throws Exception;

	P getById(String id) throws Exception;

}
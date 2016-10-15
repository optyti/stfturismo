package br.com.stfturismo.facade;

import java.io.Serializable;
import java.util.List;

public interface IBaseFacade <T extends BaseEntity> extends Serializable {

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	T findById(Long id);

	/**
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 
	 * @param entity
	 * @return
	 */
	T save(T entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	T merge(T entity);
	
	/**
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * 
	 * @param entityId
	 */
	void deleteById(Long entityId);
	
}

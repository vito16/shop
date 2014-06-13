/**
 * 
 */
package com.vito16.mvc1.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-11
 *
 */
public interface IBaseService<T,PK extends Serializable> {
	void save(T t);
	
	T find(PK id);
	
	List<T> findAll();
}

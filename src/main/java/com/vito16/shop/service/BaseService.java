/**
 * 
 */
package com.vito16.shop.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
public abstract class BaseService<T, PK extends Serializable> implements
		IBaseService<T, Serializable> {

	protected JpaRepository<T, PK> dao;

	public void setDao(JpaRepository<T, PK> dao) {// 需要依赖注入
		this.dao = dao;
	}

	@Override
	public void save(T t) {
		dao.save(t);
	}

	

	@Override
	public T find(Serializable id) {
//			return dao.findOne(id);
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

}

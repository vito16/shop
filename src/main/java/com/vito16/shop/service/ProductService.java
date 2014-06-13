/**
 * 
 */
package com.vito16.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vito16.shop.dao.ProductDao;
import com.vito16.shop.dao.ProductTypeDao;
import com.vito16.shop.model.Product;
import com.vito16.shop.model.ProductType;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-17
 * 
 */
@Service
public class ProductService {

	@Autowired
	ProductTypeDao productTypeDao;

	@Autowired
	ProductDao productDao;

	public void saveType(ProductType type) {
		productTypeDao.save(type);
	}

	public List<ProductType> findType() {
		return productTypeDao.findAll();
	}

	public void save(Product product) {
		productDao.save(product);
	}

	public Product findById(Integer id) {
		return productDao.findOne(id);
	}

	public List<Product> findAll() {
		return productDao.findAll();
	}

	public List<Product> findNew() {
		return productDao.findNewProducts();
	}
	
	public List<Product> findPop(){
		return productDao.findPopProducts();
	}
}

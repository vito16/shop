/**
 * 
 */
package com.vito16.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.common.Page;
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
@Transactional
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
		return productDao.findByOrderByCreateTimeDesc();
	}
    public List<Product> findOld() {
        return productDao.findByOrderByCreateTimeAsc();
    }
	
	public List<Product> findPop(){
		return productDao.findPopProducts();
	}

    public List<Product> findProducts(Page<Product> page, int[] pageParams) {
        page.setResult(productDao.findAll(new PageRequest(pageParams[0]-1,pageParams[1])).getContent());
        page.setTotalCount(productDao.count());
        return page.getResult();
    }
}

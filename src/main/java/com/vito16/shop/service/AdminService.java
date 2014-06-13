/**
 * 
 */
package com.vito16.shop.service;

import com.vito16.shop.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Service
public class AdminService {
	@Autowired
	private com.vito16.shop.dao.AdminDao adminDao;

	public boolean checkLogin(Admin admin) {
        admin = adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
		return admin == null ? false : true;
	}

	public void save(Admin admin) {
        adminDao.save(admin);
	}

	public Admin findOne(Integer id) {
		return adminDao.findOne(id);
	}

}

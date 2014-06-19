/**
 *
 */
package com.vito16.shop.service;

import com.vito16.shop.dao.AdminDao;
import com.vito16.shop.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public boolean checkLogin(Admin admin) {
        return findByUsernameAndPassword(admin.getUsername(), admin.getPassword()) == null ? false : true;
    }

    public Admin findByUsernameAndPassword(String username, String password) {
        return adminDao.findByUsernameAndPassword(username, password);
    }

    public void save(Admin admin) {
        adminDao.save(admin);
    }

    public Admin findOne(Integer id) {
        return adminDao.findOne(id);
    }

}

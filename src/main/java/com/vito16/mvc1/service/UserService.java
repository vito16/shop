/**
 * 
 */
package com.vito16.mvc1.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.vito16.mvc1.dao.UserDao;
import com.vito16.mvc1.model.User;
import com.vito16.util.dao.pagination.Page;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public boolean checkLogin(User user) {
		user = userDao.findByUsernameAndPassword(user.getUsername(),
				user.getPassword());
		return user == null ? false : true;
	}
	
	public User findByUsernameAndPassword(String username,String password){
		return userDao.findByUsernameAndPassword(username, password);
	}
	
	public void save(User user) {
		userDao.save(user);
	}

	public User findOne(Integer id) {
		return userDao.findOne(id);
	}

}

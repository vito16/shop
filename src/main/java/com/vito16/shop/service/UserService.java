/**
 * 
 */
package com.vito16.shop.service;

import com.vito16.shop.model.User;
import com.vito16.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userDao;

	public boolean checkLogin(User user) {
		user = userDao.findByUsernameAndPassword(user.getUsername(),
				user.getPassword());
		return user != null;
	}
	
	public User findByUsernameAndPassword(String username,String password){
		User user = userDao.findByUsernameAndPassword(username, password);
		return user;
	}

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
	
	public void save(User user) {
		userDao.save(user);
	}

	public User findOne(Integer id) {
		return userDao.getOne(id);
	}

}

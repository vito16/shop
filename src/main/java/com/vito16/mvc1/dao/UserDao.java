package com.vito16.mvc1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vito16.mvc1.model.User;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	public User findByUsernameAndPassword(String username, String password);
}

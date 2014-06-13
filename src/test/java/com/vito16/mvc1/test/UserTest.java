/**
 * 
 */
package com.vito16.mvc1.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.vito16.mvc1.dao.UserDao;
import com.vito16.mvc1.model.User;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vito16 zhouwentao16@gmail.com
 * @date 2013-7-8
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
@TransactionConfiguration
public class UserTest  {
		@Autowired
		UserDao userDao;
		
		@Test
		public void testSave(){
			User u = new User();
			u.setUsername("百度文化");
			u.setPassword("123456");
			userDao.save(u);
		}
}

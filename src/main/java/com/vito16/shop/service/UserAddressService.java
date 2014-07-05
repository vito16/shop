/**
 * 
 */
package com.vito16.shop.service;

import com.vito16.shop.dao.UserAddressDao;
import com.vito16.shop.dao.UserDao;
import com.vito16.shop.model.User;
import com.vito16.shop.model.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Service
public class UserAddressService {
	@Autowired
	private UserAddressDao userAddressDao;

	public void save(UserAddress userAddress) {
        userAddressDao.save(userAddress);
	}

	public UserAddress findById(Integer id) {
		return userAddressDao.findOne(id);
	}

    public List<UserAddress> findByUserId(Integer userId){
        User user = new User();
        user.setId(userId);
        return userAddressDao.findByUser(user);
    }

}

package com.vito16.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vito16.shop.model.User;
import com.vito16.shop.model.UserAddress;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface UserAddressDao extends JpaRepository<UserAddress, Integer> {
    List<UserAddress> findByUser(User user);
}

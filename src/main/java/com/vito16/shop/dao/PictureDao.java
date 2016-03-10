package com.vito16.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vito16.shop.model.Picture;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface PictureDao extends JpaRepository<Picture, Integer> {
}

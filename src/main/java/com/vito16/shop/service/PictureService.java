package com.vito16.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vito16.shop.dao.PictureDao;
import com.vito16.shop.model.Picture;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2014/10/14
 */
@Service
@Transactional
public class PictureService {

    @Autowired
    PictureDao pictureDao;

    public void save(Picture picture) {
        pictureDao.save(picture);
    }

    public List<Picture> findAll() {
        return pictureDao.findAll();
    }

}

package com.vito16.shop.service;

import com.vito16.shop.model.Picture;
import com.vito16.shop.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2014/10/14
 */
@Service
@Transactional
public class PictureService {

    @Autowired
    PictureRepository pictureDao;

    public void save(Picture picture) {
        pictureDao.save(picture);
    }

    public List<Picture> findAll() {
        return pictureDao.findAll();
    }

}

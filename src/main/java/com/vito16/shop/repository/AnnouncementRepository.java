package com.vito16.shop.repository;

import com.vito16.shop.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Vito
 * @email zhouwentao16@gmail.com
 * @date 2013-7-9
 * 
 */
@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}

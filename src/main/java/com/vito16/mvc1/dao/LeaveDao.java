package com.vito16.mvc1.dao;

import com.vito16.mvc1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vito16.mvc1.model.Leave;

import java.util.List;

@Repository
public interface LeaveDao extends JpaRepository<Leave, Integer> {

    List<Leave> findByLeaveUser(User user);
}

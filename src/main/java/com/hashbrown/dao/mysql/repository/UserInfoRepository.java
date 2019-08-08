package com.hashbrown.dao.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashbrown.dao.mysql.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	List<UserInfo> findByUserName(String userName);
}

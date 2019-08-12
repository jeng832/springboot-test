package com.hashbrown.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashbrown.dao.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	List<UserInfo> findByUserName(String userName);
	List<UserInfo> findByUidBetween(Long start, Long end);
	Long countByUserName(String userName);
}

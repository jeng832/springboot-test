package com.hashbrown.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hashbrown.dao.entity.GroupInfo;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long>{
	List<GroupInfo> findByGroupName(String groupName);
}

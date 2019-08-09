package com.hashbrown.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hashbrown.dao.entity.GroupInfo;

public interface GroupInfoRepository extends CrudRepository<GroupInfo, Long>{
	List<GroupInfo> findByGroupName(String groupName);
}

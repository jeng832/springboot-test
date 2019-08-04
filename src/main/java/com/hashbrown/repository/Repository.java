package com.hashbrown.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hashbrown.repository.vo.GroupInfo;

public interface Repository extends CrudRepository<GroupInfo, Long>{
	List<GroupInfo> findByGroupName(String groupName);
}

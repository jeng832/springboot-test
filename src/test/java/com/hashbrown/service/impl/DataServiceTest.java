package com.hashbrown.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hashbrown.dao.entity.GroupInfo;
import com.hashbrown.service.DataService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceTest {

	@Autowired
	private DataService dataService;
	
	/*
	List<GroupInfo> findAllGroup();
	GroupInfo saveGroup(PostGroupRequestBody g);
	List<GroupInfo> findByGroupName(String groupName);
	GroupInfo findByGid(Long gid);
	
	List<UserInfo> findAllUser();
	UserInfo saveUser(PostUserRequestBody u);
	List<UserInfo> findByUserName(String groupName);
	UserInfo findByUid(Long uid);
	String getGroupNameByUserName(String userName);
	*/
	
	@Test
	public void findAllGroup() throws Exception {
		List<GroupInfo> groupList = dataService.findAllGroup();
		assertThat(groupList).isNotNull();
	}
}

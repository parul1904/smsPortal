package com.smsPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smsPortal.dao.GroupDao;
import com.smsPortal.model.Group;
import com.smsPortal.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	GroupDao groupDao;

	@Override
	public List<Group> showAllGroups() {
		List<Group> groupList = new ArrayList<>();
		try {
			groupList = groupDao.showAllGroups();
			
		}catch(Exception e) {
			
		}
		return groupList;
	}

	@Override
	public int totalGroups() {
		int totalGroups = 0;
		try {
			totalGroups = groupDao.totalGroups();			
		}catch(Exception e) {			
		}
		return totalGroups;
	}
}

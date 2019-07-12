package com.smsPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.smsPortal.model.Group;

@Service
public interface GroupService {
	
	public List<Group> showAllGroups();
	public int totalGroups();
	public Group createGroup(Group group);

}

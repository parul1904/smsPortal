package com.smsPortal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smsPortal.model.Group;

@Repository
public interface GroupDao {

	public List<Group> showAllGroups();

	public int totalGroups();

}

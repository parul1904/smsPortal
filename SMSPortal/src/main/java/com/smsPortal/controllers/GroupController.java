package com.smsPortal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smsPortal.model.Contact;
import com.smsPortal.model.Group;
import com.smsPortal.repository.GroupRepository;
import com.smsPortal.service.GroupService;

/**
 * Created by Parul Gangwal on 22/06/2019.
 */
@RestController
public class GroupController {

	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	GroupService groupService;
	
	@GetMapping(value = "/groups")
	public ModelAndView getAllGroups() {
			List<Group> groupList = groupService.showAllGroups();
		return new ModelAndView("/groups", "groups", groupList);
	}


	@PostMapping("/groups")
	public Group createGroup(@Valid @RequestBody Group group) {
		return groupRepository.save(group);
	}

	@GetMapping("/group/{groupId}")
	public Group getNoteById(@PathVariable(value = "groupId") Long groupId) {
		return groupRepository.findOne(groupId);
	}

	@PutMapping("/group/{groupId}")
	public Group updateGroup(@PathVariable(value = "groupId") Long groupId, @Valid @RequestBody Group groupDetails) {

		Group group = groupRepository.findOne(groupId);

		group.setGroupName(groupDetails.getGroupName());
		if (groupDetails.getGroupStatus() != null)
			group.setGroupStatus(groupDetails.getGroupStatus());

		Group updatedGroup = groupRepository.save(group);
		return updatedGroup;
	}
}

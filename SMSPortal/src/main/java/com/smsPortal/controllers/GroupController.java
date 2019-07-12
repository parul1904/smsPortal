package com.smsPortal.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping(value = "/create")
	public ModelAndView addEmployeePage(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Group group = new Group();
		return new ModelAndView("createGroups", "groups", group);
	}

	@PostMapping(value = "/createGroup")
	public ModelAndView createGroup(@ModelAttribute("groups") Group group) throws IOException {
		String msg = "Group Created Successfully!";
		groupRepository.save(group);
		return new ModelAndView("createGroups", "msg", msg);
	}

	@GetMapping("/group/{groupId}")
	public ModelAndView getGroupById(@PathVariable(value = "groupId") Long groupId) {
		Group groupDetail = new Group();
		groupDetail = groupRepository.findOne(groupId);
		return new ModelAndView("updateGroup", "groupDetail", groupDetail);
	}
	
	@PutMapping("/updateGroup/{groupId}")
	public Group updateGroup(@PathVariable(value = "groupId") Long groupId, @Valid @RequestBody Group groupDetails) {

		Group group = groupRepository.findOne(groupId);

		group.setGroupName(groupDetails.getGroupName());
		if (groupDetails.getGroupStatus() != null)
			group.setGroupStatus(groupDetails.getGroupStatus());

		Group updatedGroup = groupRepository.save(group);
		return updatedGroup;
	}
}

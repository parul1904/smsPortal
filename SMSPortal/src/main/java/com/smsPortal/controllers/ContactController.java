package com.smsPortal.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smsPortal.model.Contact;
import com.smsPortal.service.ContactService;
import com.smsPortal.service.GroupService;

/**
 * Created by Parul Gangwal on 22/06/2019.
 */
@RestController
public class ContactController {

	/*
	 * @Autowired ContactRepository contactRepository;
	 */

	@Autowired
	ContactService contactService;
	
	@Autowired
	GroupService groupService;

	@GetMapping(value = "/dashboard")
	public ModelAndView loadDashboard(@RequestParam(value = "page") int page,
			@RequestParam(value = "limit") int limit, Model model) {
		List<Contact> contactList = contactService.loadDashboard(page, limit);
		long rows = contactService.getNumberOfRows();
		int totalGroups = groupService.totalGroups();
		long nOfPages = rows / limit;
		if (nOfPages % limit > 0) {
			nOfPages++;
		}
		model.addAttribute("contactList", contactList);
		model.addAttribute("totalContacts", rows);
		model.addAttribute("totalGroups", totalGroups);
		model.addAttribute("page", page);
		model.addAttribute("limit", limit);
		model.addAttribute("nOfPages", nOfPages);
		return new ModelAndView("/index", "model", model);
	}

	@GetMapping(value = "/contacts")
	public ModelAndView getAllContact() {
		List<Contact> contactList = contactService.showAllContacts();
		return new ModelAndView("/index", "contacts", contactList);
	}

	/*
	 * @PostMapping("/contacts") public Contact createContact(@Valid @RequestBody
	 * Contact contact) { return contactRepository.save(contact); }
	 */

	/*
	 * @PutMapping("/contact/{groupId}") public Group
	 * updateGroup(@PathVariable(value = "groupId") Long
	 * groupId, @Valid @RequestBody Contact contactDetails) {
	 * 
	 * Contact contact = contactRepository.findById(groupId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Contact", "id", groupId));
	 * 
	 * contact.setGroupName(groupDetails.getGroupName());
	 * group.setGroupStatus(groupDetails.getGroupStatus());
	 * 
	 * Contact updatedGroup = contactRepository.save(contact); return updatedGroup;
	 * }
	 */
}

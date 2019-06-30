package com.smsPortal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smsPortal.model.Contact;
import com.smsPortal.repository.ContactRepository;
import com.smsPortal.service.ContactService;

/**
 * Created by Parul Gangwal on 22/06/2019.
 */
@RestController
public class ContactController {

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	ContactService contactService;

	@GetMapping(value = "/contacts")
	public ModelAndView getAllContact() {
		List<Contact> contactList = contactService.showAllContacts();
		return new ModelAndView("/index", "contacts", contactList);
	}

	@PostMapping("/contacts")
	public Contact createContact(@Valid @RequestBody Contact contact) {
		return contactRepository.save(contact);
	}

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

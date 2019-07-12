package com.smsPortal.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smsPortal.model.Contact;
import com.smsPortal.service.ContactService;

/**
 * Created by Parul Gangwal on 06/07/2019.
 */
@RestController
public class SmsController {

	/*
	 * @Autowired ContactRepository contactRepository;
	 */

	@Autowired
	ContactService contactService;

	@GetMapping("/bulkSms")
	public ModelAndView getNoteById(@PathVariable(value = "groupId") Long groupId,
			HttpServletRequest request, HttpServletResponse response) {
		String groupIdFromURL = request.getParameter("groupId");
		List<Contact> contactList = contactService.showContactByGroupId(Long.parseLong(groupIdFromURL));
		return new ModelAndView("bulkSms", "contactList", contactList);
	}
}

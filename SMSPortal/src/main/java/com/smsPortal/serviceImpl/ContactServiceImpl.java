package com.smsPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsPortal.dao.ContactDao;
import com.smsPortal.model.Contact;
import com.smsPortal.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactDao contactDao;

	public List<Contact> showAllContacts(){
		List<Contact> contactList = new ArrayList<>();
		try {
			contactList = contactDao.showAllContacts();			
		}catch(Exception e) {			
		}
		return contactList;
	}
}

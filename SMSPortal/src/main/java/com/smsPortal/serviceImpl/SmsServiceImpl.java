package com.smsPortal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smsPortal.dao.ContactDao;
import com.smsPortal.model.Contact;
import com.smsPortal.service.SmsService;

@Service
public class SmsServiceImpl implements SmsService{
	
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

	@Override
	public List<Contact> loadDashboard(int page, int limit) {
		List<Contact> contactList = new ArrayList<>();
		try {
			contactList = contactDao.loadDashboard(page, limit);			
		}catch(Exception e) {			
		}
		return contactList;
	}

	@Override
	public int getNumberOfRows() {
		int numOfRows = 0;
		try {
			numOfRows = contactDao.getNumberOfRows();			
		}catch(Exception e) {			
		}
		return numOfRows;
	}
}

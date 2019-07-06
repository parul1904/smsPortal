package com.smsPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smsPortal.model.Contact;

@Service
public interface ContactService {
	
	public List<Contact> showAllContacts();
	public List<Contact> loadDashboard(int page, int limit);
    public int getNumberOfRows();

}

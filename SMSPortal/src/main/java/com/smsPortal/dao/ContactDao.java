package com.smsPortal.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smsPortal.model.Contact;

@Repository
public interface ContactDao {
	
	public List<Contact> showAllContacts();

}

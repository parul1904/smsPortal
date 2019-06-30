package com.smsPortal.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.smsPortal.dao.ContactDao;
import com.smsPortal.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Contact> showAllContacts() {
		List<Contact> contactList = em.createQuery(" from Contact c order by c.contactId ").getResultList();
		return contactList;
	}
}

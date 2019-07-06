package com.smsPortal.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> loadDashboard(int page, int limit) {
		int start = page * limit - limit;
		Query query = em.createQuery("from Contact c order by c.contactId ");
		query.setFirstResult(start);
		query.setMaxResults(limit);
		List<Contact> contactList = query.getResultList();
		return contactList;
	}

	@Override
	public int getNumberOfRows() {
		Query query = em.createNativeQuery("SELECT COUNT(contact_Id) from tbl_contacts c");
		int count = ((Number) query.getSingleResult()).intValue();  
		return count;
	}
}

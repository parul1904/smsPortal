package com.smsPortal.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.smsPortal.dao.GroupDao;
import com.smsPortal.model.Group;


@Repository
public class GroupDaoImpl implements GroupDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Group> showAllGroups() {
		List<Group> groupList = em.createQuery(" from Group g order by g.groupId ").getResultList();
		return groupList;
	}
}

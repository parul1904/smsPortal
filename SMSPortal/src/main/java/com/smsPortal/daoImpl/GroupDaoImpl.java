package com.smsPortal.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smsPortal.dao.GroupDao;
import com.smsPortal.model.Group;
import com.smsPortal.repository.GroupRepository;


@Repository
public class GroupDaoImpl implements GroupDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	GroupRepository groupRepo;

	@SuppressWarnings("unchecked")
	public List<Group> showAllGroups() {
		List<Group> groupList = em.createQuery(" from Group g order by g.groupId ").getResultList();
		return groupList;
	}

	@Override
	public int totalGroups() {
		Query query = em.createNativeQuery("SELECT COUNT(group_Id) from tbl_groups c");
		int count = ((Number) query.getSingleResult()).intValue();  
		return count;
	}

	@Override
	public Group createGroup(Group group) {
		return groupRepo.save(group);
	}
}

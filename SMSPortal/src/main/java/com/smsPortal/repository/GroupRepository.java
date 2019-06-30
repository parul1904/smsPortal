package com.smsPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsPortal.model.Group;

/**
 * Created by Parul Gangwal on 22/06/2019.
 */

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}

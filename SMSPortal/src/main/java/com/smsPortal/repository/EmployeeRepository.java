package com.smsPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smsPortal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

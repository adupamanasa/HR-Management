package com.hr.repository;

import org.springframework.dao.DataAccessException;

import com.hr.entity.Employee;

public interface EmployeeRepository {

    Employee findByEmpNo(int empNo) throws DataAccessException;

    void save(Employee employee) throws DataAccessException;
	
}

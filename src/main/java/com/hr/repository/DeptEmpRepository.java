package com.hr.repository;

import org.springframework.dao.DataAccessException;

import com.hr.entity.DeptEmp;

public interface DeptEmpRepository {

	void save(DeptEmp DeptEmp) throws DataAccessException;

}

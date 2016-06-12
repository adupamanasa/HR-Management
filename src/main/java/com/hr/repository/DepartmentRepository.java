package com.hr.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hr.entity.Department;

public interface DepartmentRepository {
	   
    Department findByDeptNo(String deptNo) throws DataAccessException;

    List<Department> findAll() throws DataAccessException;

    void save(Department department) throws DataAccessException;
	
}

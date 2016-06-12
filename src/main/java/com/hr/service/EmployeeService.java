package com.hr.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.hr.entity.Department;
import com.hr.entity.DeptEmp;
import com.hr.entity.DeptManager;
import com.hr.entity.Employee;
import com.hr.entity.Salary;
import com.hr.entity.Title;

public interface EmployeeService {
	
	    Department findDepartmentByDeptNo(String deptNo) throws DataAccessException;

	    Collection<Department> findDepartments()throws DataAccessException;
	    
	    Employee findEmployeeByEmpNo(int empNo)throws DataAccessException;

	    void saveEmployee(Employee employee)throws DataAccessException;
	    
	    void saveDepartment(Department department)throws DataAccessException;
	    
	    void saveSalary(Salary salary)throws DataAccessException;
	    
	    void saveTitle(Title title)throws DataAccessException;
	    
	    void saveDeptEmp(DeptEmp deptEmp)throws DataAccessException;
	    
	    void saveDeptManager(DeptManager deptManager)throws DataAccessException;
}

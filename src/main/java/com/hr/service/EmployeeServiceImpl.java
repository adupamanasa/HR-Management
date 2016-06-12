package com.hr.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;

import com.hr.entity.Employee;
import com.hr.entity.Department;
import com.hr.entity.DeptEmp;
import com.hr.entity.DeptManager;
import com.hr.entity.Salary;
import com.hr.entity.Title;
import com.hr.repository.EmployeeRepository;
import com.hr.repository.DepartmentRepository;
import com.hr.repository.SalaryRepository;
import com.hr.repository.TitleRepository;
import com.hr.repository.DeptEmpRepository;
import com.hr.repository.DeptManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private SalaryRepository salaryRepository;
    private TitleRepository titleRepository;
    private DeptEmpRepository deptEmpRepository;
    private DeptManagerRepository deptManagerRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,SalaryRepository salaryRepository,TitleRepository titleRepository,DeptEmpRepository deptEmpRepository,DeptManagerRepository deptManagerRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.salaryRepository = salaryRepository;
        this.titleRepository = titleRepository;
        this.deptEmpRepository = deptEmpRepository;
        this.deptManagerRepository = deptManagerRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
	public Department findDepartmentByDeptNo(String deptNo) throws DataAccessException{
           return departmentRepository.findByDeptNo(deptNo);
           
    }
           
    @Override
    @Transactional(readOnly = true)
	public Collection<Department> findDepartments()throws DataAccessException {
           return departmentRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)    
	public Employee findEmployeeByEmpNo(int empNo)throws DataAccessException {
           return employeeRepository.findByEmpNo(empNo);
    }
    
    @Override
    @Transactional
	public void saveEmployee(Employee employee)throws DataAccessException {
    	 employeeRepository.save(employee);
    }
    
    @Override
    @Transactional   
	public void saveDepartment(Department department)throws DataAccessException { 
    	departmentRepository.save(department);
    }
    
    @Override
    @Transactional    
	public void saveSalary(Salary salary)throws DataAccessException {
    	salaryRepository.save(salary);
    }
    
    @Override
    @Transactional   
	public void saveTitle(Title title)throws DataAccessException {
    	titleRepository.save(title);
    }
    
    @Override
    @Transactional  
	public void saveDeptEmp(DeptEmp deptEmp)throws DataAccessException {
         deptEmpRepository.save(deptEmp);
    }
    @Override
    @Transactional   
	public void saveDeptManager(DeptManager deptManager)throws DataAccessException {
    	deptManagerRepository.save(deptManager);
    	
    }
}

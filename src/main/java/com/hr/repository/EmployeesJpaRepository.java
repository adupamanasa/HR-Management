package com.hr.repository;

//import java.util.Collection;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.hr.entity.Employee;

/**
 * Repository : Employees.
 */
public interface EmployeesJpaRepository extends EmployeeRepository, Repository<Employee, Integer>  {

	@Override
	@Query("SELECT e.empNo,e.firstName,e.lastName,e.gender,t.title, dm.deptNo, d.deptName, e.hireDate, s.salary FROM DeptEmp de LEFT JOIN FETCH de.employees e LEFT JOIN FETCH dm.departments d LEFT JOIN e.titles t LEFT JOIN e.salaries s WHERE s.toDate > CURRENT_DATE and t.toDate > CURRENT_DATE and e.empNo=:empNo")  
    public Employee findByEmpNo(@Param("empNo")int empNo);
	
	
}

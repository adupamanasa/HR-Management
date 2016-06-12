package com.hr.repository;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.Repository;
import com.hr.entity.Department;
import com.hr.repository.DepartmentRepository;

/**
 * Repository : Departments.
 */
public interface DepartmentsJpaRepository extends DepartmentRepository, Repository<Department, String> {

	@Override
	@Query("SELECT d.dept_no, d.dept_name, e.emp_no, e.first_name, e.last_name, e.gender FROM DeptManager dm LEFT JOIN FETCH dm.employees e LEFT JOIN FETCH dm.departments d WHERE dm.toDate > CURRENT_DATE and dm.deptNo:deptNo")
	public Department findByDeptNo(@Param("deptNo") String deptNo);
	
}

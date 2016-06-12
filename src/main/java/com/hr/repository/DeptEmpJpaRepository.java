package com.hr.repository;

import org.springframework.data.repository.Repository;
import com.hr.entity.DeptEmp;
//import com.hr.entity.DeptEmpManagerPK;
//import java.util.List;

public interface DeptEmpJpaRepository extends DeptEmpRepository, Repository<DeptEmp, String> {

	

}

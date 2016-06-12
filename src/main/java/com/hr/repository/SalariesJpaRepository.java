package com.hr.repository;

//import java.util.List;

import org.springframework.data.repository.Repository;

import com.hr.entity.Salary;
//import com.hr.entity.SalaryPK;

/**
 * Repository : Salaries.
 */
public interface SalariesJpaRepository extends SalaryRepository, Repository<Salary, Integer>  {

}

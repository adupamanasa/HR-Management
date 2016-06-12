package com.hr.repository;


import org.springframework.dao.DataAccessException;
import com.hr.entity.Salary;
//import com.hr.entity.SalaryPK;

public interface SalaryRepository {

	   void save(Salary salary) throws DataAccessException;
}

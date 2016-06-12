package com.hr.repository;

//import java.util.List;

//import org.springframework.dao.DataAccessException;

//import java.util.List;

import org.springframework.data.repository.Repository;
//import org.springframework.data.jpa.repository.Query;
import com.hr.entity.DeptManager;
//import com.hr.entity.DeptEmpManagerPK;


public interface DeptManagerJpaRepository extends DeptManagerRepository, Repository<DeptManager, String> {

}

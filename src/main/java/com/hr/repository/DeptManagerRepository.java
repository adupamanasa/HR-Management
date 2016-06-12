package com.hr.repository;

//import java.util.List;

import org.springframework.dao.DataAccessException;
import com.hr.entity.DeptManager;

public interface DeptManagerRepository {
	
	void save(DeptManager deptManager) throws DataAccessException;
}


package com.hr.repository;

//import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hr.entity.Title;
//import com.hr.entity.TitlePK;

public interface TitleRepository {

    
    void save(Title title) throws DataAccessException;

}

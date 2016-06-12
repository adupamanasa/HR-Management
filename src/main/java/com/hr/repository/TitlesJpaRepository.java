package com.hr.repository;

//import java.util.List;

import org.springframework.data.repository.Repository;

//import com.hr.entity.TitlePK;
import com.hr.entity.Title;

/**
 * Repository : Titles.
 */
public interface TitlesJpaRepository extends TitleRepository, Repository<Title, Integer> {

}

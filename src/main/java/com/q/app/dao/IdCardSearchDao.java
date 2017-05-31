package com.q.app.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.q.app.entity.IdCardSearchEntity;


public interface IdCardSearchDao extends PagingAndSortingRepository<IdCardSearchEntity, Long>, 
	JpaSpecificationExecutor<IdCardSearchEntity> {

}

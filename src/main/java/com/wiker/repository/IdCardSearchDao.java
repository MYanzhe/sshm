package com.wiker.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wiker.entity.IdCardSearchEntity;


public interface IdCardSearchDao extends PagingAndSortingRepository<IdCardSearchEntity, Long>, 
	JpaSpecificationExecutor<IdCardSearchEntity> {

}

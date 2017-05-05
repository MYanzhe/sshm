package com.wiker.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wiker.entity.TestEntity;

public interface TestDao extends PagingAndSortingRepository<TestEntity, Long>, 
	JpaSpecificationExecutor<TestEntity> {

}

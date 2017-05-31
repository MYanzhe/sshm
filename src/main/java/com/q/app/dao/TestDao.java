package com.q.app.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.q.app.entity.TestEntity;

public interface TestDao extends PagingAndSortingRepository<TestEntity, Long>, 
	JpaSpecificationExecutor<TestEntity> {

}

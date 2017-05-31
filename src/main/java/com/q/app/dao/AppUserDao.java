package com.q.app.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.q.app.entity.AppUserEntity;

public interface AppUserDao extends PagingAndSortingRepository<AppUserEntity, Long>, 
	JpaSpecificationExecutor<AppUserEntity> {

}

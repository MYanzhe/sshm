package com.wiker.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wiker.entity.AppUserEntity;

public interface AppUserDao extends PagingAndSortingRepository<AppUserEntity, Long>, 
	JpaSpecificationExecutor<AppUserEntity> {

}

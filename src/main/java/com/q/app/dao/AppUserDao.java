package com.q.app.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.q.app.entity.AppUserEntity;

public interface AppUserDao extends PagingAndSortingRepository<AppUserEntity, Long>, 
	JpaSpecificationExecutor<AppUserEntity> {
	@Query("select u from AppUserEntity u where u.phone = ?1 and u.password = ?2")
	public AppUserEntity login(String phone,String password);

	@Query("select count(*) from AppUserEntity u where u.phone = ?1")
	public int checkPhoneUsable(String phone);
}

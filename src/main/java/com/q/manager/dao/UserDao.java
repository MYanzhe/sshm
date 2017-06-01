package com.q.manager.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.q.manager.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
	@Query("select u from User u where u.username = ?1 and u.password = ?2")
	public User login(String username,String password);
	
	@Query("select u from User u where u.username = ?1")
	public User checkUsername(String username);
}

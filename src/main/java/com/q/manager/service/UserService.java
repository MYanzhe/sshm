package com.q.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.q.manager.dao.UserDao;
import com.q.manager.entity.User;

@Service
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	private UserDao dao;
	
	@Transactional(readOnly=false)
	public User add(User t){
		return dao.save(t);
	}
	
	@Transactional(readOnly=false)
	public void del(long id){
		dao.delete(id);
	}
	
	public List<User> getAll(){
		return (List<User>) dao.findAll();
	}
}

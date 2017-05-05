package com.wiker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiker.entity.AppUserEntity;
import com.wiker.repository.AppUserDao;

@Service
@Transactional(readOnly = true)
public class AppUserService {

	@Autowired
	private AppUserDao dao;
	
	@Transactional(readOnly=false)
	public AppUserEntity add(AppUserEntity t){
		return dao.save(t);
	}
	
	@Transactional(readOnly=false)
	public void del(long id){
		dao.delete(id);
	}
	
	public List<AppUserEntity> getAll(){
		return (List<AppUserEntity>) dao.findAll();
	}
}

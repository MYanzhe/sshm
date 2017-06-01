package com.q.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.q.app.dao.AppUserDao;
import com.q.app.entity.AppUserEntity;

import tools.MD5Tools;

@Service
@Transactional(readOnly = true)
public class AppUserService {

	@Autowired
	private AppUserDao dao;
	
	@Transactional(readOnly=false)
	public AppUserEntity add(AppUserEntity t){
		t.setPassword(MD5Tools.getPwd(t.getPassword()));
		return dao.save(t);
	}
	
	@Transactional(readOnly=false)
	public void del(long id){
		dao.delete(id);
	}
	
	public List<AppUserEntity> getAll(){
		return (List<AppUserEntity>) dao.findAll();
	}

	public AppUserEntity login(AppUserEntity entity) {
		return dao.login(entity.getPhone(),MD5Tools.getPwd(entity.getPassword()));
	}

	public boolean checkPhoneUsable(AppUserEntity entity) {
		return (dao.checkPhoneUsable(entity.getPhone()) < 1);
	}
}

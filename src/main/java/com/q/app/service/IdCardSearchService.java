package com.q.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.q.app.dao.IdCardSearchDao;
import com.q.app.entity.IdCardSearchEntity;

@Service
@Transactional(readOnly = true)
public class IdCardSearchService {

	@Autowired
	private IdCardSearchDao testDao;
	
	@Transactional(readOnly=false)
	public IdCardSearchEntity add(IdCardSearchEntity t){
		return testDao.save(t);
	}
	
	@Transactional(readOnly=false)
	public void del(long id){
		testDao.delete(id);
	}
	
	public List<IdCardSearchEntity> getAll(){
		return (List<IdCardSearchEntity>) testDao.findAll();
	}
}

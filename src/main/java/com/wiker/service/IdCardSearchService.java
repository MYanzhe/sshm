package com.wiker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiker.entity.IdCardSearchEntity;
import com.wiker.repository.IdCardSearchDao;

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

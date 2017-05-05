package com.wiker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiker.entity.TestEntity;
import com.wiker.repository.TestDao;

@Service
@Transactional(readOnly = true)
public class TestService {

	@Autowired
	private TestDao testDao;
	
	@Transactional(readOnly=false)
	public TestEntity add(TestEntity t){
		return testDao.save(t);
	}
	
	@Transactional(readOnly=false)
	public void del(long id){
		testDao.delete(id);
	}
	
	public List<TestEntity> getAll(){
		return (List<TestEntity>) testDao.findAll();
	}
}

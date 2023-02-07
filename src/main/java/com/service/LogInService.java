package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.LogInEntity;
import com.repo.LogInRepo;

@Service
public class LogInService {

	@Autowired
	LogInRepo repo;
	
	public LogInEntity getdetail(String email,String password) {
		LogInEntity log = repo.findByEmailAndPassword(email,password);
//		return log;
		if(log==null) {
			return log;
		}
		if(log.getPassword().equalsIgnoreCase(password)) {
			return log;
		}
		return null;
	}
}

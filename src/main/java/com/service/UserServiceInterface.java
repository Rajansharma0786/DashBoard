package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.User;

public interface UserServiceInterface {
	List<User> getAllRecord();
	void saveRecord(User user);
	User getrecordById(long id);
	  Page< User > findPaginated(int pageNo, int pageSize);
	  
//	List<User> getAllRecord(Integer pageSize, Integer page);

}

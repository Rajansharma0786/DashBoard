package com.repo;



import java.util.List;

//import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


import com.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

//	public Page<User> findByPage(Pageable pageable,int pageSize);
	public List<User> findByClientContaining(String Client);
	public List<User> findByServiceContaining(String ser);
	public List<User> findByFrontEndUrlContaining(String frontEndUrl);
	public List<User> findByschedulersBackendUrlContaining(String schedulersBackendUrl);
	
//	public List<User> findByServiceContaining(String Service);
//	public List<User> findByUser
} 

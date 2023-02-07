package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repo.UserRepo;


@Service
public class UserService implements UserServiceInterface {
	@Autowired
	UserRepo repo;
	
	@Override
	public void saveRecord(User user) {
		this.repo.save(user);
	}
	
	@Override
	public List<User> getAllRecord() {
		
//	    List<UserEntity> students = new ArrayList();
//	
//	    repo.findAll()
//	    .forEach(students::add);
//		Pageable pageable = PageRequest.of(page, 10);
//    	Page<User> contact = 	repo.findAll(pageable);
//    	if(contact.hasContent()) {
//    		return contact.getContent();
//    	}
//    	else {
//    		return new 	ArrayList<User>();
//    	}
		return repo.findAll();
	}
	
	
    @Override
    public User getrecordById(long id) {
        Optional < User > optional = repo.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" Record not found for id :: " + id);
        }
        return user;
    }

	@Override
	public Page<User> findPaginated(int pageNo, int pageSize) {

		 Pageable pageable = PageRequest
				 .of(pageNo - 1, pageSize);
		 return repo.findAll(pageable);
		
	}

	public List<User> findByClient(String client) {
		
		List<User> user = repo.findByClientContaining(client);
		
		return user;
	}

	public List<User> findByService(String ser){
		List<User> user = repo.findByServiceContaining(ser);
		System.out.println("The value of service is inside user service "+user);
		return user;
		
}

	public List<User> findByFrontEndUrl(String frontUrl){
		List<User> user = repo.findByFrontEndUrlContaining(frontUrl);
		return user;
	}
	
	public List<User> findBySchedulers(String schedulers){
		List<User> user  = repo.findByschedulersBackendUrlContaining(schedulers);
		//System.out.println("The value of list inside service class"+user);
		return user;
	}
	
  
//	public List<User> exportToExcel(HttpServletResponse response) throws IOException{
//		
//		List<User> user = repo.findAll();
//		ExcelCrontroller excel = new ExcelCrontroller(user);
//		excel.exportDataToExcel(response);
//		return user;
//	
//	
//	}
	
}

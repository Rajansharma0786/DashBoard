package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
public class SaveRecordController {
	
	
	@Autowired
	UserService service;
	

	@RequestMapping(value="/saveRecord",method=RequestMethod.POST)
	public Map<String,Object> saveEmployee(@RequestBody User user,Model model) {
		// save employee to database
		
		Map<String,Object> response=new HashMap<>(); 
		
		service.saveRecord(user);
		System.out.println("Successfully Saved");
		model.addAttribute("Successfull");
		


		System.out.println("The value of json file is"+user);
		
		
		response.put("response", user);
	
		return response;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Map<String,Object> showFormForUpdate(@RequestBody User user) {

		// get employee from the service
		User user1 = service.getrecordById(user.getId());
		
		//create map to send the response
		
		Map<String,Object> response = new HashMap<>();
		response.put("response", user1);

		// set employee as a model attribute to pre-populate the form

		return response;
	}
	
//	@GetMapping("/All")
	@RequestMapping(value="/All",method = RequestMethod.GET)
	
	public Map<String,List<User>> index(@RequestParam("val") Integer pageNo, Model model, Pageable pageable) {
//
//		System.out.println("The value of Pageable is" + pageable);
		System.out.println("The value of page Number is"+pageNo);
		int pageSize = 10;
		pageNo = pageNo == null ? 1 : pageNo;
//
		Page<User> page = service.findPaginated(pageNo, pageSize);
//
		List<User> list = page.getContent();
		System.out.println("The Value of List is "+list);
		Map<String,List<User>> response = new  HashMap<>();
		response.put("response", list);
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		System.out.println("The value of total number" + page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		System.out.println("The value of total element" + page.getTotalElements());
//		model.addAttribute("recordlist", list);
//
		return response;
		
		
	}
	
	

	
}

package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
//@Controller
public class SearchController {

	@Autowired
	UserService service;
	
//	@GetMapping("/search/{value}")
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public Map<String,List<User>> search(@RequestParam("val") String value){
		Map<String,List<User>>response=new HashMap<>(); 
		List<User> user = service.findByClient(value);
		response.put("response",user);
		System.out.println("The value of response");
		 return response;
	}
	@RequestMapping(value="/searchbyService", method=RequestMethod.GET)
	public Map<String,List<User>> searchByService(@RequestParam("val") String value){
//		System.out.println("The value of service is"+value);
		Map<String,List<User>>response=new HashMap<>(); 
		List<User> user1 = service.findByService(value);
		response.put("response", user1);
//		System.out.println("The value of response is"+response);
		 return response;
	}
//	@GetMapping("/searchbyFrontUrl/{value}")
	@RequestMapping(value="/searchbyFrontUrl",method=RequestMethod.GET)
	public Map<String,List<User>> searchByFrontUrl(@RequestParam("val") String value){
		
		Map<String,List<User>>response=new HashMap<>(); 
		List<User> user2 = service.findByFrontEndUrl(value);
		response.put("response", user2);
		return response;	
	}

	/*
	 * @GetMapping("/searchbySchedulers")
	 */	@RequestMapping( value="/searchbySchedulers",method=RequestMethod.GET)
	public Map<String,List<User>> searchByScheduler(@RequestParam("val") String value){
		
//		System.out.println("The value of"+value);
		Map<String,List<User>>response=new HashMap<>(); 
		List<User> user3 = service.findBySchedulers(value);
		response.put("response", user3);
//		System.out.println("The value of scheduler list is"+response);
		return response;	
	}
	
}

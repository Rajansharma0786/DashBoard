package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

import com.entity.*;
import com.repo.UserRepo;
import com.service.UserService;

import javax.servlet.http.*;

@Controller

public class UserController {

	@Autowired
	UserService service;
	@Autowired
	UserRepo repo;

	// getting request for pagenation
//	@GetMapping("/{pageNo}")
//	public String index(@PathVariable("pageNo") Integer pageNo, Model model, Pageable pageable) {
//
//		System.out.println("The value of Pageable is" + pageable);
//		int pageSize = 10;
//		pageNo = pageNo == null ? 1 : pageNo;
//
//		Page<User> page = service.findPaginated(pageNo, pageSize);
//
//		List<User> list = page.getContent();
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		System.out.println("The value of total number" + page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		System.out.println("The value of total element" + page.getTotalElements());
//		model.addAttribute("recordlist", list);
//
//		return "index";
//	}

	@GetMapping("/showNewRecordForm")
	public String showNewEmployeeForm(Model model) {

		// create model attribute to bind form data
		User user = new User();
		model.addAttribute("record", user);
		
		return "AddRecord";
	}

	@PostMapping("/DashBoard/saveRecord")
	public String saveEmployee(@ModelAttribute("record") User user, Model model, Pageable pageable) {
		
		// save employee to database
		service.saveRecord(user);

		int pageSize = 10;
		int pageNo = 1;

		Page<User> page = service.findPaginated(pageNo, pageSize);
		List<User> list = page.getContent();
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
//		System.out.println("The value of total number" + page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
//		System.out.println("The value of total element" + page.getTotalElements());
		model.addAttribute("recordlist", list);
//		  System.out.println("Thevalue of user amount"+user.getAmount());
//	        model.addAttribute("recordlist",user);
//			 Page < User > page = service.findPaginated(pageNo, pageSize);
//
//	        index(null, model, null)
		return "index";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String search(@RequestParam("val") String client, Model model) {
		List<User> user = service.findByClient(client);
		model.addAttribute("recordlist", user);
		return "SearchFile";
	}

//	 @GetMapping("/showservices/{service}")
	@RequestMapping(value = "/showservices", method = RequestMethod.GET)
	public String searchByService(@RequestParam("val") String ser, Model model) {
		System.out.println("The Name of service is" + ser);
		List<User> user1 = service.findByService(ser);
		System.out.println("the value of service is" + user1);
		model.addAttribute("recordlist", user1);
		return "SearchFile";
	}

//	 @GetMapping("/showbyfrontEndUrl/{frontEndUrl}")
	@RequestMapping(value = "/showbyfrontEndUrl", method = RequestMethod.GET)
	public String searchByFrontEndUrl(@RequestParam("val") String frontEnd, Model model) {
		List<User> user2 = service.findByFrontEndUrl(frontEnd);
		model.addAttribute("recordlist", user2);
		return "SearchFile";
	}

//	 @GetMapping("/showbyschedulersBackendUrl/{schedulersBackendUrl}")
	@RequestMapping(value = "/showbyschedulersBackendUrl", method = RequestMethod.GET)
	public String searchByschedulersBackendUrl(@RequestParam("val") String backEndUrl, Model model) {
		System.out.println("The Value of backend url" + backEndUrl);
		List<User> user3 = service.findBySchedulers(backEndUrl);
		model.addAttribute("recordlist", user3);
		System.out.println("The value of user 3" + user3);
		return "SearchFile";

	}

}

package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.LogInEntity;
import com.service.LogInService;

import javax.servlet.http.*;

@Controller
@CrossOrigin

public class LogInController {

	@Autowired
	LogInService service;


	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login() {
		System.out.println("inside page");
		return "forgot-password-18";

	}

	@PostMapping("/userlogin")

	public String logindetail(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
//
//		System.out.println("The vlaue of user email is" + email);
//
//		System.out.println("The value of user password is" + password);

		LogInEntity login = service.getdetail(email, password);

		if (email == null || login == null || password == null) {
			return "forgot-password-18";
		}

		if (login.getEmail().equals(email) && login.getPassword().equals(password)) {
			session.setAttribute("email", email);
//			System.out.println("The value of session is " + session);
			return "AddRecord";

		} else {
			return "forgot-password-18";
		}

	}

	@GetMapping("/logout")
	public String logoutButton(HttpSession session) {
//		System.out.println(session.getAttribute("email"));
		session.removeAttribute("email");
		session.invalidate();

		return "redirect:/";
	}

}

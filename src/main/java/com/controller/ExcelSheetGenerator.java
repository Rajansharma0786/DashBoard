package com.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.repo.UserRepo;
import com.service.ExcelService;

@RestController
public class ExcelSheetGenerator {

	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/export")
	public ResponseEntity<InputStreamResource> excelUserReport(HttpSession session) throws IOException{
		if(session.getAttribute("email")==null) {
			List<User> list = new ArrayList<>();
//			System.out.println("The Value of list is"+list);
			ByteArrayInputStream byteArrayInputStream = ExcelService.dataToExcel(list);
			HttpHeaders headers =new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename = Record.xlsx");
			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));		
		}
		else {
			
		
		List<User> list = userRepo.findAll();
		ByteArrayInputStream byteArrayInputStream = ExcelService.dataToExcel(list);
		HttpHeaders headers =new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename = VisiontrekRecord.xlsx");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(byteArrayInputStream));
		}
		
	}
	
	
	
	
}

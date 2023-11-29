package com.bhuvana.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhuvana.user.service.impl.CommunicationService;
import com.bhuvana.user.service.impl.CommunicationServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
//	CommunicationService communicationService;
	@Qualifier("communicationServiceImpl")
	CommunicationService CommunicationImpl;
	
	@GetMapping("/test")
	public String getUser() {
		return "This is User service.";
	}

	@GetMapping("/dept")
	public String getDept() {
		return CommunicationImpl.getDepartmentDetails();
	}
	@GetMapping("/deptWeb")
	public String getDeptWeb() {
		return CommunicationImpl.getDepartmentDetailsByWebClient();
	}
}

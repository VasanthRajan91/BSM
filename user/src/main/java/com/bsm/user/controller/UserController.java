package com.bsm.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsm.user.model.Login;
import com.bsm.user.model.Registration;
import com.bsm.user.service.RegistrationService;

@RestController
@CrossOrigin()
@RequestMapping("user")
public class UserController {
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@PostMapping("/registration")
	public Registration createUser(@RequestBody Registration registration, HttpServletRequest request) {
		Registration reg = new Registration();
		try {
			reg = this.registrationService.saveNewUser(registration);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reg;
	}

	@PostMapping("/login")
	public String login(@RequestBody Login login, HttpServletRequest request) {
		String token = "0";
		try {
			if (login.getUsername() != null && login.getPassword() != null) {
				token = this.registrationService.CheckUser(login);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return token;
	}
}

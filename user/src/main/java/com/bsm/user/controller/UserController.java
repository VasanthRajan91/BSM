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
import com.bsm.user.model.ResponseData;
import com.bsm.user.service.RegistrationService;

@RestController
@CrossOrigin()
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@PostMapping("/registration")
	public ResponseData createUser(@RequestBody Registration registration, HttpServletRequest request) {
		Registration reg = new Registration();
		ResponseData resData = new ResponseData();
		try {
			reg = this.registrationService.saveNewUser(registration);
			if(reg != null && reg.getCustomerid().contains("R")) {
				resData.setResponseCode("200");
				resData.setReponseMsg("Registered Successfully");
				resData.setRegistration(reg);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resData.setResponseCode("404");
			resData.setReponseMsg("Registered Failed");
		}
		return resData;
	}

	@PostMapping("/login")
	public ResponseData login(@RequestBody Login login, HttpServletRequest request) {
		String token = "0";
		ResponseData resData = new ResponseData();
		try {
			if (login.getUsername() != null && login.getPassword() != null) {
				token = this.registrationService.CheckUser(login);
				resData.setResponseCode("200");
				resData.setReponseMsg("Token Generated Successfully");
				resData.setToken(token);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			resData.setResponseCode("404");
			resData.setReponseMsg("Token Generated Failed");
		}
		return resData;
	}
	
	@PostMapping(value = "/accountDetails")
	public ResponseData getAccountDetails(@RequestBody String token) {
		Registration accountDetails = new Registration();
		ResponseData resData = new ResponseData();
		try {
			accountDetails = this.registrationService.getAccountDetails(token);
			if(accountDetails != null) {
				resData.setResponseCode("200");
				resData.setReponseMsg("Account Details Fetched");
				resData.setRegistration(accountDetails);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			resData.setResponseCode("404");
			resData.setReponseMsg("Account Details Failed");
		}

		return resData;

	}
	
	@PostMapping(value= "/updateAccountDetails")
	public ResponseData updateAccountDetails(@RequestBody Registration registration) {
		String msg = null;
		ResponseData resData = new ResponseData();
		try {
			msg = this.registrationService.updateAccountDetails(registration);
			resData.setResponseCode("200");
			resData.setReponseMsg("Account Details Updated Successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resData.setResponseCode("404");
			resData.setReponseMsg("Account Details Update Failed");
		}
		return resData;
	}
}

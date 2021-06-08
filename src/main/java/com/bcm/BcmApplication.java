package com.bcm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcm.pojo.Loan;
import com.bcm.pojo.Login;
import com.bcm.pojo.Registration;
import com.bcm.service.RegistrationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bcm")
public class BcmApplication {

	@Autowired
	public RegistrationService registrationService;

	public static void main(String[] args) {
		SpringApplication.run(BcmApplication.class, args);
	}

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

	@PostMapping(value = "/applyloan")
	public String applyloan(@RequestBody Loan loan, HttpServletRequest request) {
		String loanID = null;
		try {
			String token = (String) request.getHeader("Token");
			loanID = this.registrationService.applyLoan(loan, token);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return loanID;
	}

	@PostMapping(value = "/accountDetails")
	public Registration getAccountDetails(@RequestBody String token) {
		Registration accountDetails = new Registration();
		try {
			accountDetails = this.registrationService.getAccountDetails(token);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return accountDetails;

	}
	
	@PostMapping(value= "/updateAccountDetails")
	public String updateAccountDetails(@RequestBody Registration registration) {
		String msg = null;
		try {
			msg = this.registrationService.updateAccountDetails(registration);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

}

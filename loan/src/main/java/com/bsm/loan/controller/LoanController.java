package com.bsm.loan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsm.loan.model.Loan;
import com.bsm.loan.service.LoanService;

@RestController
@CrossOrigin
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	public LoanService loanService;
	
	@PostMapping(value = "/applyloan")
	public String applyloan(@RequestBody Loan loan, HttpServletRequest request) {
		String loanID = null;
		try {
			String token = (String) request.getHeader("Token");
			loanID = this.loanService.applyLoan(loan, token);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return loanID;
	}
}

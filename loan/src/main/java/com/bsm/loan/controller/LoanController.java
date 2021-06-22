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
import com.bsm.user.model.ResponseData;

@RestController
@CrossOrigin
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	public LoanService loanService;
	
	@PostMapping(value = "/applyloan")
	public ResponseData applyloan(@RequestBody Loan loan, HttpServletRequest request) {
		String loanID = null;
		ResponseData resData = new ResponseData();
		try {
			String token = (String) request.getHeader("Token");
			loanID = this.loanService.applyLoan(loan, token);
			resData.setResponseCode("200");
			resData.setReponseMsg("Applied Loan Successfully");
			resData.setToken(loanID);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resData.setResponseCode("404");
			resData.setReponseMsg("Applied Loan Failed");
		}
		return resData;
	}
}

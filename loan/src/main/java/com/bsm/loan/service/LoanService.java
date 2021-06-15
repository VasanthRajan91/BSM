package com.bsm.loan.service;

import org.springframework.stereotype.Service;

import com.bsm.loan.model.Loan;

@Service
public interface LoanService {
	String applyLoan(Loan loan, String token);
}

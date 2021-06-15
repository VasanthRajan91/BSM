package com.bsm.loan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsm.loan.model.Loan;
import com.bsm.loan.repository.LoanRepository;
import com.bsm.loan.service.LoanService;
import com.bsm.user.repository.RegistrationRepository;

@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	private RegistrationRepository registrationRepository;
	@Autowired
	private LoanRepository loanRepository;
	
	@Override
	public String applyLoan(Loan loan, String token) {
		// TODO Auto-generated method stub
		try {
			int count = registrationRepository.checkUserToken(token);
			if (count == 1) {
				String custID = registrationRepository.getCustID(token);
				loan.setCustomerid(custID);
				loanRepository.save(loan);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return token;
	}
}

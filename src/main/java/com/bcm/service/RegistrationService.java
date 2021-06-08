package com.bcm.service;

import org.springframework.stereotype.Service;

import com.bcm.pojo.Loan;
import com.bcm.pojo.Login;
import com.bcm.pojo.Registration;

@Service
public interface RegistrationService {

	Registration saveNewUser(Registration registration);
	String createToken();
	String CheckUser(Login login);
	String applyLoan(Loan loan, String token);
	Registration getAccountDetails(String token);
	String updateAccountDetails(Registration registration);

}

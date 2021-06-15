package com.bsm.user.service;

import org.springframework.stereotype.Service;

import com.bsm.user.model.Login;
import com.bsm.user.model.Registration;


@Service
public interface RegistrationService {
	Registration saveNewUser(Registration registration);
	String createToken();
	String CheckUser(Login login);
	Registration getAccountDetails(String token);
	String updateAccountDetails(Registration registration);
}

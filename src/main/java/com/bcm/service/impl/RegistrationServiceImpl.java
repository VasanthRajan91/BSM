package com.bcm.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcm.pojo.Loan;
import com.bcm.pojo.Login;
import com.bcm.pojo.Registration;
import com.bcm.repository.LoanRepository;
import com.bcm.repository.RegistrationRepository;
import com.bcm.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public Registration saveNewUser(Registration registration) {
		// TODO Auto-generated method stub
		String currentDate = getCurrentDate();
		String customerID = "R-" + getCustomerID();
		String accountNo = getAccountNo();
		registration.setCustomerid(customerID);
		registration.setAccountno(accountNo);
		registration.setRegistrationdate(currentDate);
		try {
			registrationRepository.save(registration);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return registration;
	}

	private String getCustomerID() {
		// TODO Auto-generated method stub
		int regNo = 0;
		Random objGenerator = new Random();
		for (int iCount = 0; iCount < 1; iCount++) {
			regNo = objGenerator.nextInt(900) + 100;
			System.out.println("Reg No : " + regNo);
		}
		return String.valueOf(regNo);
	}

	private String getAccountNo() {
		StringBuilder accountNo = new StringBuilder();
		int randomNo = 0;
		Random objGenerator = new Random();
		for (int iCount = 0; iCount < 2; iCount++) {
			randomNo = objGenerator.nextInt(90000000) + 10000000;
			accountNo.append(randomNo);
		}
		System.out.println("Acc No : " + accountNo.toString());
		return accountNo.toString();
	}

	@Override
	public String createToken() {
		// TODO Auto-generated method stub
		int token = 0;
		Random objGenerator = new Random();
		for (int iCount = 0; iCount < 1; iCount++) {
			token = objGenerator.nextInt(900000) + 100000;
			System.out.println("token : " + token);
		}
		return String.valueOf(token);
	}

	public String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	@Override
	public String CheckUser(Login login) {
		// TODO Auto-generated method stub
		String token = "0";
		try {
			int count = registrationRepository.checkUserAuth(login.getUsername(), login.getPassword());
			if (count == 1) {
				token = createToken();
				int updateToken = registrationRepository.updateToken(token, login.getUsername(), login.getPassword());
				System.out.println(updateToken);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return token;
	}

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

	@Override
	public Registration getAccountDetails(String token) {
		// TODO Auto-generated method stub
		Registration accountDetails = new Registration();
		int count = registrationRepository.checkUserToken(token);
		if (count == 1) {
			accountDetails = registrationRepository.getAccountDetails(token);
		}
		return accountDetails;
	}

	@Override
	public String updateAccountDetails(Registration reg) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			Registration accountDetails = registrationRepository.getAccountDetails(reg.getToken());
			accountDetails.setCountry(reg.getCountry());
			accountDetails.setState(reg.getState());
			accountDetails.setBankname(reg.getBankname());
			accountDetails.setBranchname(reg.getBranchname());
			accountDetails.setIndentificationprooftype(reg.getIndentificationprooftype());
			accountDetails.setIndentificationdocno(reg.getIndentificationdocno());
			accountDetails.setAccountholdername(reg.getAccountholdername());
			accountDetails.setAccountholdernumber(reg.getAccountholdernumber());
			accountDetails.setAccountholderaddress(reg.getAccountholderaddress());
			accountDetails.setAddress(reg.getAddress());
			accountDetails.setContact(reg.getContact());
			accountDetails.setEmail(reg.getEmail());
			accountDetails.setMarital(reg.getMarital());
			accountDetails.setCitizenship(reg.getCitizenship());
			accountDetails.setCitizenstatus(reg.getCitizenstatus());
			accountDetails.setGuardiantype(reg.getGuardiantype());
			accountDetails.setGuardianname(reg.getGuardianname());
			registrationRepository.save(accountDetails);
			msg = "Updated Sucessfully";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg = "Error in update";
		}
		return msg;
	}

}

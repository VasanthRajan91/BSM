package com.bsm.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String guardianname;
	private String address;
	private String email;
	private String gender;
	private String marital;
	private String contact;
	private String dob;
	private String accounttype;
	private String customerid;
	private String accountno;
	private String token;
	private String country;
	private String state;
	private String registrationdate;
	private String bankname;
	private String branchname;
	private String indentificationprooftype;
	private String indentificationdocno;
	private String accountholdername;
	private String accountholdernumber;
	private String accountholderaddress;
	private String citizenship;
	private String citizenstatus;
	private String guardiantype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(String registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getIndentificationprooftype() {
		return indentificationprooftype;
	}

	public void setIndentificationprooftype(String indentificationprooftype) {
		this.indentificationprooftype = indentificationprooftype;
	}

	public String getIndentificationdocno() {
		return indentificationdocno;
	}

	public void setIndentificationdocno(String indentificationdocno) {
		this.indentificationdocno = indentificationdocno;
	}

	public String getAccountholdername() {
		return accountholdername;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}

	public String getAccountholdernumber() {
		return accountholdernumber;
	}

	public void setAccountholdernumber(String accountholdernumber) {
		this.accountholdernumber = accountholdernumber;
	}

	public String getAccountholderaddress() {
		return accountholderaddress;
	}

	public void setAccountholderaddress(String accountholderaddress) {
		this.accountholderaddress = accountholderaddress;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getCitizenstatus() {
		return citizenstatus;
	}

	public void setCitizenstatus(String citizenstatus) {
		this.citizenstatus = citizenstatus;
	}

	public String getGuardiantype() {
		return guardiantype;
	}

	public void setGuardiantype(String guardiantype) {
		this.guardiantype = guardiantype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGuardianname() {
		return guardianname;
	}

	public void setGuardianname(String guardianname) {
		this.guardianname = guardianname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarital() {
		return marital;
	}

	public void setMarital(String marital) {
		this.marital = marital;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

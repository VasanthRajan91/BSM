package com.bsm.loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String customerid;
	private String loantype;
	private String loanamount;
	private String loanapplydate;
	private String interest;
	private String loanduration;
	private String coursefee;
	private String course;
	private String fathername;
	private String annualincome;
	private String companyname;
	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
	public String getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(String loanamount) {
		this.loanamount = loanamount;
	}
	public String getLoanapplydate() {
		return loanapplydate;
	}
	public void setLoanapplydate(String loanapplydate) {
		this.loanapplydate = loanapplydate;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getLoanduration() {
		return loanduration;
	}
	public void setLoanduration(String loanduration) {
		this.loanduration = loanduration;
	}
	public String getCoursefee() {
		return coursefee;
	}
	public void setCoursefee(String coursefee) {
		this.coursefee = coursefee;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getAnnualincome() {
		return annualincome;
	}
	public void setAnnualincome(String annualincome) {
		this.annualincome = annualincome;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	
}


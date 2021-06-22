package com.org.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class BankManagementSystemException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	private HttpStatus errorCode;
	private String errorMessage;
	
	public BankManagementSystemException() {
		// TODO Auto-generated constructor stub
	}

	public BankManagementSystemException(String errorMessage) {
		super();
		this.errorCode = HttpStatus.NOT_FOUND;
		this.errorMessage = errorMessage;
	}
	
	public BankManagementSystemException(HttpStatus errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}

package com.bcm.repository;

import org.springframework.data.repository.CrudRepository;
import com.bcm.pojo.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {
	

}
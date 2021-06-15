package com.bsm.loan.repository;

import org.springframework.data.repository.CrudRepository;

import com.bsm.loan.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

}

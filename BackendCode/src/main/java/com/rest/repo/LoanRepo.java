package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan, Long>{

}

package com.rest.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Loan;
import com.rest.entity.User;
import com.rest.service.LoanService;

@RestController
@RequestMapping("/api/loan")
public class LoanController {
	
	 private final LoanService loanService;

	    @Autowired
	    public LoanController(LoanService loanService) {
	        this.loanService = loanService;
	    }

	    @PostMapping
	    public Loan loanBook(@RequestParam Long userId,
	                         @RequestParam Long bookId,
	                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
	        return loanService.loanBook(userId, bookId, dueDate);
	    }
	    
	    @PostMapping("/add")
		public Loan AddLoan(@RequestBody Loan loan1) {
			return loanService.newLoan(loan1);
	    }
	    @GetMapping("/getall")
		public List<Loan> ListLoan() {
			return loanService.getAllLoan();
		}

		@GetMapping("/getone/{id}")
		public Optional<Loan> findIndivitualLoan (@PathVariable Long id) {
			return loanService.getSingleLoan(id);
		}

		@DeleteMapping("/del/{id}")
		public void deleteLoan(@PathVariable Long id) {
			loanService.dltLoan(id);
		}

	/*	@GetMapping("/{id}")
		public ResponseEntity<Loan> getLoanByID(@PathVariable Long id) {
			Loan loan = LoanService.getLoanByID(id);
			if (loan == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(loan);
			}
		}*/

		@GetMapping("/update/{id}")
		public ResponseEntity<Loan> UpdateLoanByID(@PathVariable Long id, @RequestBody Loan z) {
			Loan loan = loanService.UpdateSingleLoan1(id, z);
			if (loan == null) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok(loan);
			}
		}


}



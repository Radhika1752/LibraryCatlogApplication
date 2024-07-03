package com.rest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.Book;
import com.rest.entity.Loan;
import com.rest.entity.User;
import com.rest.repo.BookRepo;
import com.rest.repo.LoanRepo;
import com.rest.repo.UserRepo;

@Service
public class LoanService {
	
	 private final LoanRepo loanRepository;
	    private final UserRepo userRepository;
	    private final BookRepo bookRepository;

	    @Autowired
	    public LoanService(LoanRepo loanRepository, UserRepo userRepository, BookRepo bookRepository) {
	        this.loanRepository = loanRepository;
	        this.userRepository = userRepository;
	        this.bookRepository = bookRepository;
	    }

	    public Loan loanBook(Long userId, Long bookId, LocalDate dueDate) {
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new IllegalArgumentException("User not found with id " + userId));

	        Book book = bookRepository.findById(bookId)
	                .orElseThrow(() -> new IllegalArgumentException("Book not found with id " + bookId));

	        Loan loan = new Loan();
	        loan.setUser(user);
	        loan.setBook(book);
	        loan.setLoanedDate(LocalDate.now());
	        loan.setDueDate(dueDate);

	        return loanRepository.save(loan);
	    }
	    
	    public Loan newLoan (Loan loan)
		{
			return loanRepository.save(loan);
		}
	    
	    public List<Loan> getAllLoan()
		{
			return loanRepository.findAll();
		}
		
		public Optional<Loan> getSingleLoan(Long id)
		{
			return loanRepository.findById(id);
		}
		
		public void dltLoan(Long id)
		{
			loanRepository.deleteById(id);
		}
		
	/*	public Loan getSingleLoan1(Long id)
		{
			return loanRepository.findById(id).orElse(null);
		}
		*/
		public Loan UpdateSingleLoan1(Long id, Loan z)
		{
			Optional<Loan> s=loanRepository.findById(id);
			if(s.isPresent())
			{
				Loan loan1=s.get();
				loan1.setLoanedDate(z.getLoanedDate());
				loan1.setDueDate(z.getDueDate());
				loan1.setReturnedDate(z.getReturnedDate());
				
				return loanRepository.save(loan1);
			}
			return null;
		}
		

}


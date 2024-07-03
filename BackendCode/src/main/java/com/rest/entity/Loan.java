package com.rest.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn Book book;
	
	private LocalDate loanedDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(Long id, User user, Book book, LocalDate loanedDate, LocalDate dueDate, LocalDate returnedDate) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.loanedDate = loanedDate;
		this.dueDate = dueDate;
		this.returnedDate = returnedDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LocalDate getLoanedDate() {
		return loanedDate;
	}
	public void setLoanedDate(LocalDate loanedDate) {
		this.loanedDate = loanedDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
	
	
	

}

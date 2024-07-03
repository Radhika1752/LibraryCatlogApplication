package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.Book;
import com.rest.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bRepo;
	
	public Book newBook (Book b)
	{
		return bRepo.save(b);
	}
	
	public List<Book> getAllCustomer()
	{
		return bRepo.findAll();
	}
	
	public Optional<Book> getSingleBook(Long id)
	{
		return bRepo.findById(id);
	}
	
	public void dltBook(Long id)
	{
		bRepo.deleteById(id);
	}
	
	public Book getSingleBook1(Long id)
	{
		return bRepo.findById(id).orElse(null);
	}
	
	public Book UpdateSingleBook1(Long id, Book z)
	{
		Optional<Book> s=bRepo.findById(id);
		if(s.isPresent())
		{
			Book b1=s.get();
			b1.setTitle(z.getTitle());
			b1.setAuthor(z.getAuthor());
			b1.setIsbn(z.getIsbn());
		//	b1.setAvailable(z.isAvailable());
			return bRepo.save(b1);
		}
		return null;
	}
	


}

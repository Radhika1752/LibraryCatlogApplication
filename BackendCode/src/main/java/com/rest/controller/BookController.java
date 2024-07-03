package com.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Book;
import com.rest.service.BookService;

@RequestMapping("bo")
@CrossOrigin("*")
@RestController
public class BookController {

	@Autowired
	private BookService bService;

	@PostMapping("/add")
	public Book createBook(@RequestBody Book b1) {
		return bService.newBook(b1);
	}

	@GetMapping("/getall")
	public List<Book> ListUser() {
		return bService.getAllCustomer();
	}

	@GetMapping("/getone/{id}")
	public Optional<Book> findIndivitualBook(@PathVariable Long id) {
		return bService.getSingleBook(id);
	}

	@DeleteMapping("/del/{id}")
	public void deleteBook(@PathVariable Long id) {
		bService.dltBook(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable Long id) {
		Book b = bService.getSingleBook1(id);
		if (b == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(b);
		}
	}

	@GetMapping("/update/{id}")
	public ResponseEntity<Book> UpdateBookByID(@PathVariable Long id, @RequestBody Book z) {
		Book b = bService.UpdateSingleBook1(id, z);
		if (b == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(b);
		}
	}

}
package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

}

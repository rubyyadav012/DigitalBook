package com.BookService.bookRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookService.Entity.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{
	

}

package com.digitalBook.bookRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.Entity.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{
	

}

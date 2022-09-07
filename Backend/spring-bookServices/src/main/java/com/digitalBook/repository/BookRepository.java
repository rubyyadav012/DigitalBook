package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{
	

}

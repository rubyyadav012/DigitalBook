package com.digitalBook.bookRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.Entity.Author;



public interface AuthorRepo extends JpaRepository<Author,Integer>{
	

}

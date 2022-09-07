package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.Author;



public interface AuthorRepo extends JpaRepository<Author,Integer>{
	

}

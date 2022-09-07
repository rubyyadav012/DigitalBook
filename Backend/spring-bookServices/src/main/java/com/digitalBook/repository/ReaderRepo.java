package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.Reader;

public interface ReaderRepo extends JpaRepository<Reader,Integer>{
	

}

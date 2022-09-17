package com.digitalBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalBook.entity.Bill;

public interface BillRepo extends JpaRepository<Bill,Integer> {
	
	

}

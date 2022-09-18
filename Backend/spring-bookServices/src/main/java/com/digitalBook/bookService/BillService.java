package com.digitalBook.bookService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.digitalBook.entity.Bill;

public interface BillService {

	Bill payment(Bill bill);

	public Optional<Bill> findById(int id);

	
}

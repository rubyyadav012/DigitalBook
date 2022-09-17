package com.digitalBook.controller;


import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitalBook.entity.Bill;

@CrossOrigin
@RequestMapping(path="/bill")
public interface BillController {

	
	@PostMapping(path="/payment")
	ResponseEntity<String> payment(@RequestBody Bill bill);
	
	@GetMapping(path="/getPaymentDetail/{billId}")
	Optional<Bill>  getById(@PathVariable int billId);
}

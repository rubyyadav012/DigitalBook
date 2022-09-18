package com.digitalBook.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.digitalBook.Utils.DigitalBooksUtils;
import com.digitalBook.bookService.BillService;
import com.digitalBook.constants.DigitalBookConstant;
import com.digitalBook.entity.Bill;
import com.digitalBook.repository.BillRepo;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillRepo billRepo;
	
	public Bill payment(Bill bill) {
			
	 return billRepo.save(bill);
	
}

	@Override
	public Optional<Bill> findById(int id) {
		return billRepo.findById(id);
		
	}

}
	
	
	


	


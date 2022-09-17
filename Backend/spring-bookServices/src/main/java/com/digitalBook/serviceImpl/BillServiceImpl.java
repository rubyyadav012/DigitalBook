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
	
	public ResponseEntity<String> payment(Bill bill) {
	log.info("Inside generateReport()");
	try {
		billRepo.save(bill);
			
	}catch(Exception ex){
	ex.getStackTrace();
	
	}
	return DigitalBooksUtils.getResponseEntity(DigitalBookConstant.SUCCESSFULLY_PAYMENT,HttpStatus.ACCEPTED);
	
}

	@Override
	public Optional<Bill> findById(int id) {
		return billRepo.findById(id);
		
	}

}
	
	
	


	


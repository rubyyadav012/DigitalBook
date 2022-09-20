package com.digitalBook.controllerImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.digitalBook.controller.BillController;
import com.digitalBook.bookService.BillService;
import com.digitalBook.entity.Bill;

@RestController
public class BillControllerImpl implements BillController {

	@Autowired
	BillService billService;

	@Override
	public ResponseEntity<?> payment(Bill bill) {
		try {
			bill = billService.payment(bill);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(bill, HttpStatus.CREATED);
	}

	public Optional<Bill> getById(int billId) {
		return billService.findById(billId);
	}

}

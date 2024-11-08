package com.capgemini.fds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.capgemini.fds.entities.Bill;
import com.capgemini.fds.exceptions.DuplicateBillException;
import com.capgemini.fds.exceptions.NoSuchBillException;
import com.capgemini.fds.services.IBillService;

@RestController
@RequestMapping("bills")
public class BillController {
	@Autowired
	private IBillService service;
	
	//http://localhost/9090/OnlineFoodDeliveryApp/bills
	@GetMapping(path = "{billId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bill> getBillId(@PathVariable int billId) throws NoSuchBillException {
		Bill result = service.findBillById(billId);
		ResponseEntity<Bill> response = null;
		if (result != null) {
			response = new ResponseEntity<Bill>(result, HttpStatus.OK);
			return response;
		}
		throw new NoSuchBillException("Student Not Found");
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws DuplicateBillException{
		Bill result = service.addBill(bill);
		ResponseEntity<Bill> response = null;
		if(result !=null) {
			response = new ResponseEntity<Bill>(HttpStatus.OK);
			return response;
		}
		throw new DuplicateBillException("Bill already exists");
	}
	
	
	//http://localhost:9090/OnlineFoodDeliveryApp/bills
	@GetMapping(produces="application/json")
	public List<Bill> getAllBills(){
		List<Bill> result = service.viewBills();
		return result;
	}
}
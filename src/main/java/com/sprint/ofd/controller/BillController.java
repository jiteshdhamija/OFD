package com.sprint.ofd.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Bill;
import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.service.IBillService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class BillController extends HttpServlet {
	
	//autowired ibillservice
	@Autowired
	IBillService billServ;
	
	
	
	public void doPut(HttpServletRequest request, HttpServletResponse response) {
	    // Add the "Access-Control-Allow-Origin" and "Access-Control-Allow-Methods" headers
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "PUT");

	    // Continue with your controller code here...
	  }
	
	//controller calling billservice to add bill
	@PostMapping("/bill/add/")
	public ResponseEntity<Bill> addBill(@RequestBody Integer orderId) {
		Bill b = billServ.addBill(orderId);
		ResponseEntity<Bill> response = new ResponseEntity<>(b, HttpStatus.CREATED); 
		return response;
		
	}
	
	//controller calling billservice to update bill
	@PutMapping("/bill/update/{billId}/")
	public ResponseEntity<Bill> updateBill(@Valid @PathVariable Bill bill) {
		Bill b = billServ.updateBill(bill);
		ResponseEntity<Bill> response = new ResponseEntity<>(b, HttpStatus.OK);
		return response;
		
	}
	
	//controller calling billservice to delete bill
	
	@DeleteMapping("/bill/delete/{bill}/")
	public ResponseEntity<String> removeBill( @PathVariable int bill) {
		String b = billServ.removeBill(bill);
		ResponseEntity<String> response = new ResponseEntity<>(b, HttpStatus.OK); 
		return response;
		
	}
	
	
	//controller calling billservice to view bill
	@GetMapping("/bill/view/{bill}/")
	public ResponseEntity<Bill> viewBill(@PathVariable int bill) {
		Bill b = billServ.viewBill(bill);
		ResponseEntity<Bill> response = new ResponseEntity<>(b, HttpStatus.OK); 
		return response;
		
	}
	
	//controller calling billservice to view bills in between start date and end date 
	@GetMapping("/bill/viewBills/byDates/{startDate}/{endDate}/")
	public ResponseEntity<List<Bill>> viewBills(@Valid @PathVariable("startDate") LocalDate startDate,@PathVariable("endDate") LocalDate endDate) {
		List<Bill> b = billServ.viewBills(startDate,endDate);
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(b, HttpStatus.OK);
		return  response;
		
	}
	//controller calling billservice to view bill mapped to customerId
	
	@GetMapping("bills/viewBills/byCustId/{custId}/")
	public ResponseEntity<List<Bill>> viewBills(@Valid @PathVariable Customer cust) {
		List<Bill> b = billServ.viewBills(cust);
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(b, HttpStatus.OK); 
		return  response;
	}

}

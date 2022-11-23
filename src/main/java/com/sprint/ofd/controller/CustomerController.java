package com.sprint.ofd.controller;
import com.sprint.ofd.service.ICustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Customer;

@RestController
public class CustomerController {
	
    @Autowired
	ICustomerService cusServ;
   
    
    /*
     * calls addCustomer from service implementation class and adds customer in db
     */
    @PostMapping("/customer/add")
    ResponseEntity<Customer> addCustomer(  @RequestBody Customer cust) {
    	Customer newCus=cusServ.addCustomer(cust);
    	return new ResponseEntity<>(newCus , HttpStatus.CREATED);
    };
    /*
     * calls updateCustomer from service implementation and updates customer in db
     */
    @PutMapping("/customer/update/{customerId}")
    ResponseEntity<Customer> updateCustomer( @PathVariable int customerId, @RequestBody Customer customer) {
		Customer updatedCus=cusServ.updateCustomer(customerId, customer);
		return new ResponseEntity<>(updatedCus , HttpStatus.OK);
	}
    /*
     * calls removeCustomer from service implementation and removes customer from db
     */
    @DeleteMapping("/customer/delete/{customerId}")
    ResponseEntity<Customer> removeCustomer( @PathVariable int customerId) {
    	Customer delCust=cusServ.removeCustomer(customerId);
		return new ResponseEntity<>(delCust , HttpStatus.OK);
    }
    /*
     * calls viewCustomer from service implementation and views a customer using customerId
     */
    @GetMapping("/customer/view/{customerId}")
    ResponseEntity<Customer> viewCustomer( int customerId ) {
		Customer customer=cusServ.viewCustomer(customerId);
		return new ResponseEntity<>(customer , HttpStatus.OK);
	};
	/*
	 * calls viewAllCustomer from service implementation and returns all customers
	 */
	@GetMapping("/customer/viewAll")
	ResponseEntity <List<Customer>> viewAllCustomer(){
		List<Customer> custList =cusServ.viewAllCustomer();
		return new ResponseEntity<>(custList , HttpStatus.OK);
	}
}
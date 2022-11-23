package com.sprint.ofd.service;

import java.util.List;
import com.sprint.ofd.repository.ICustomerRepository;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.exceptions.CustomerNotFoundException;


@Service
public class CustomerServiceImpl implements ICustomerService {
@Autowired
	ICustomerRepository cusRepo;

private Logger logger = LogManager.getLogger();
   
/*
 * Here we are adding customer to the database
 */
	@Override
	public Customer addCustomer(Customer cust) {
		
		return cusRepo.save(cust);
	}
	/*
	 * Here we are updating customer to the database according to the respective customerId
	 */
	@Override
	public Customer updateCustomer(int customerId ,  Customer cust) {
		Optional<Customer> opt	=cusRepo.findById(customerId);
		if(opt.isPresent()) {
	     return cusRepo.save(cust);
		}
		else {
			throw new CustomerNotFoundException("Customer not found with id: " + cust.getCustomerId());
		}
	}
	/*
	 * Here we are removing customer from the database according to the respective customerId
	 */
	@Override
	public Customer removeCustomer(int customerId) {
		Optional<Customer> opt =cusRepo.findById(customerId);
		Customer cust = null;
		if(opt.isPresent()) {
			cust=opt.get();
			cusRepo.deleteById(customerId);	
		}
		return cust;	
	}
	/*
	 * Here we are viewing customer from the database according to the respective customerId
	 */
	@Override
	public Customer viewCustomer(int customerId) {
		logger.info("Sending request to the repository");
		Optional<Customer> opt = cusRepo.findById(customerId);
		Customer customer = null;
		if(opt.isPresent()) {
			logger.info("Customer found with given id");
			customer=opt.get();
		}
		return customer ;
	}
	/*
	 * Here we are viewing all the customers from the database
	 */
	@Override
	public List<Customer> viewAllCustomer() {
		List<Customer> cusList = cusRepo.findAll();
		return cusList;
	}
}

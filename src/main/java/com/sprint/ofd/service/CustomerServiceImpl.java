package com.sprint.ofd.service;

import java.util.List;
import com.sprint.ofd.repository.ICustomerRepository;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.dto.CustomerInputDto;
import com.sprint.ofd.entity.dto.CustomerOutputDto;
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
	public CustomerOutputDto addCustomer(CustomerInputDto cust) {
		//changing dto to object
		Customer customer=new Customer();
		customer.setAddress(cust.getAddress());
		customer.setAge(cust.getAge());
		customer.setEmail(cust.getEmail());
		customer.setFirstName(cust.getFirstName());
		customer.setLastName(cust.getLastName());
		customer.setGender(cust.getGender());
		customer.setMobileNumber(cust.getMobileNumber());
		
		//saving to repo
		customer=cusRepo.save(customer);
		
		//converting to outputdto
		CustomerOutputDto out=new CustomerOutputDto();
		out.setCustomerId(customer.getCustomerId());
		out.setEmail(customer.getEmail());
		out.setFirstName(customer.getFirstName());
		out.setLastName(customer.getLastName());
		return out;
	}
	/*
	 * Here we are updating customer to the database according to the respective customerId
	 */
	@Override
	public CustomerOutputDto updateCustomer(int customerId ,  CustomerInputDto cust) {
		Optional<Customer> opt	=cusRepo.findById(customerId);
		Customer customer=new Customer();
		CustomerOutputDto out=new CustomerOutputDto();
		if(opt.isPresent()) {
			customer.setAddress(cust.getAddress());
			customer.setAge(cust.getAge());
			customer.setCustomerId(customerId);
			customer.setEmail(cust.getEmail());
			customer.setFirstName(cust.getFirstName());
			customer.setGender(cust.getGender());
			customer.setLastName(cust.getLastName());
			customer.setMobileNumber(cust.getMobileNumber());
			Customer c=cusRepo.save(customer);
			out.setCustomerId(customerId);
			out.setEmail(c.getEmail());
			out.setFirstName(c.getFirstName());
			out.setLastName(c.getLastName());
			return out;
		}
		else {
			throw new CustomerNotFoundException("Customer not found with id: " );
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
			return cust;
		}
		else 
			throw new CustomerNotFoundException("Customer Not Found with given ID");
			
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
			return customer ;
		}
		else
			throw new CustomerNotFoundException("Customer Not Found With Given ID");
		
	}
	/*
	 * Here we are viewing all the customers from the database
	 */
	@Override
	public List<Customer> viewAllCustomer() {
		List<Customer> cusList = cusRepo.findAll();
		if(!cusList.isEmpty())
			return cusList;
		else
			throw new CustomerNotFoundException("No customers found");
	}
	@Override
	public List<Customer> viewByName(String name) {
		List<Customer> list=cusRepo.findByFirstName(name);
		if(!list.isEmpty())
			return list;
		else
			throw new CustomerNotFoundException("No Customer found with given name");
			
	}
	
}

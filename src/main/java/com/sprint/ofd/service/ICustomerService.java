	package com.sprint.ofd.service;
import java.util.List;
import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.dto.CustomerInputDto;
import com.sprint.ofd.entity.dto.CustomerOutputDto;

public interface ICustomerService {

	public CustomerOutputDto addCustomer(CustomerInputDto cust);
	public CustomerOutputDto updateCustomer(int customerId,CustomerInputDto cust);
	public Customer removeCustomer(int customerId);
	public Customer viewCustomer(int customerId );
	public List<Customer> viewAllCustomer(); 
}
	package com.sprint.ofd.service;
import java.util.List;
import com.sprint.ofd.entity.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer cust);
	public Customer updateCustomer(int customerId,Customer cust);
	public Customer removeCustomer(int customerId);
	public Customer viewCustomer(int customerId );
	public List<Customer> viewAllCustomer(); 
}
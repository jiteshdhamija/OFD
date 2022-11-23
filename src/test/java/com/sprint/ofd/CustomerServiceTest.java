package com.sprint.ofd;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.repository.ICustomerRepository;
import com.sprint.ofd.service.CustomerServiceImpl;

@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
// @InjectMock - Creates instance of a class and injects mocks that are created
// with @Mock

@InjectMocks
CustomerServiceImpl cusServ;

// @MockBean - Creates Mock of a class or interface
@MockBean
ICustomerRepository cusRepo;

// Initialization of mock objects
@BeforeEach
void init() {
MockitoAnnotations.openMocks(this);
}


@Test
void addCustomerTest() {
Customer customer = new Customer();
customer.setCustomerId(100);
customer.setFirstName("sagar");
customer.setLastName("minhas");

Mockito.when(cusRepo.save(customer)).thenReturn(customer);

Customer newCus = cusServ.addCustomer(customer);

assertEquals(100, newCus.getCustomerId());
assertEquals("sagar", newCus.getFirstName());
assertEquals("minhas", newCus.getLastName());
}

@Test
void addCustomerFailTest() {
Customer customer = new Customer();
customer.setCustomerId(100);
customer.setFirstName("sagar");
customer.setLastName("minhas");

Mockito.when(cusRepo.save(customer)).thenReturn(customer);

Customer newCus = cusServ.addCustomer(customer);

assertEquals(100, newCus.getCustomerId());
assertEquals(456, newCus.getFirstName());
assertEquals("minhas", newCus.getLastName());
}

@Test
void viewCustomerTest() {
Customer customer = new Customer();
customer.setCustomerId(250);
customer.setGender("male");
customer.setEmail("sagar1@gmail.com");

Mockito.when(cusRepo.findById(250)).thenReturn(Optional.of(customer));
Customer response = cusServ.viewCustomer(250);

assertEquals(250, response.getCustomerId());
assertEquals("male", response.getGender());
assertEquals("sagar1@gmail.com", response.getEmail());
}

@Test
void viewCustomerFailTest() {
Customer customer = new Customer();
customer.setCustomerId(250);
customer.setGender("male");
customer.setEmail("sagar1@gmail.com");

Mockito.when(cusRepo.findById(250)).thenReturn(Optional.of(customer));
Customer response = cusServ.viewCustomer(250);

assertEquals(250, response.getCustomerId());
assertEquals(678, response.getGender());
assertEquals("sagar1@gmail.com", response.getEmail());
}

@Test
void viewAllCustomerTest() {
Customer cus1 = new Customer();
cus1.setCustomerId(500);
cus1.setFirstName("first");
cus1.setLastName("last");


Customer cus2 = new Customer();
cus2.setCustomerId(501);
cus2.setFirstName("sprint");
cus2.setLastName("one");

List<Customer> cusList = new ArrayList<>();
cusList.add(cus1);
cusList.add(cus2);

Mockito.when(cusRepo.findAll()).thenReturn(cusList);

List<Customer> cusVl = cusServ.viewAllCustomer();
assertEquals(2, cusVl.size());
assertEquals("first", cusVl.get(0).getFirstName());


}

@Test
void viewAllCustomerFailTest() {
Customer cus1 = new Customer();
cus1.setCustomerId(500);
cus1.setFirstName("first");
cus1.setLastName("last");


Customer cus2 = new Customer();
cus2.setCustomerId(501);
cus2.setFirstName("sprint");
cus2.setLastName("one");

List<Customer> cusList = new ArrayList<>();
cusList.add(cus1);
cusList.add(cus2);

Mockito.when(cusRepo.findAll()).thenReturn(cusList);

List<Customer> cusVl = cusServ.viewAllCustomer();
assertEquals(2, cusVl.size());
assertEquals("sagar", cusVl.get(0).getFirstName());


}
}
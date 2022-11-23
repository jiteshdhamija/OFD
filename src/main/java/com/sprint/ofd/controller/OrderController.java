package com.sprint.ofd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.OrderDetails;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.service.IOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderServ;
	
	//controller calling orderService to add order
	@PostMapping("/order/add/{order}/")
	public ResponseEntity<OrderDetails> addOrder(@Valid @RequestBody OrderDetails order) {
		OrderDetails ord = orderServ.addOrder(order);
		ResponseEntity<OrderDetails> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	//controller calling orderService to update order
	@PutMapping("/order/update/{order}/")
	public ResponseEntity<OrderDetails> updateOrder(@Valid @PathVariable OrderDetails order) {
		OrderDetails ord = orderServ.updateOrder(order);
		ResponseEntity<OrderDetails> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	
	//controller calling orderService to remove order
	@DeleteMapping("/order/delete/{order}/")
	public ResponseEntity<OrderDetails> removeOrder(@Valid @PathVariable OrderDetails order) {
		OrderDetails ord = orderServ.removeOrder(order);
		ResponseEntity<OrderDetails> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	//controller calling orderService to view order
	@GetMapping("/order/viewOrder/{order}/")
	public ResponseEntity<OrderDetails> viewOrder(@Valid @PathVariable OrderDetails order) {
		OrderDetails ord = orderServ.viewOrder(order);
		ResponseEntity<OrderDetails> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	//controller calling orderService to view all orders mapped to reaurantName
	@GetMapping("/order/viewAll/{res}/")
	public ResponseEntity<List<OrderDetails>> viewAllOrders(@Valid @PathVariable Restaurant resName) {
		List<OrderDetails> ord = orderServ.viewAllOrders(resName);
		ResponseEntity<List<OrderDetails>> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	//controller calling orderService to view all orders based on Customer
	@GetMapping("/order/viewAll/{cust}")
	public ResponseEntity<List<OrderDetails>> viewAllOrders(@Valid @PathVariable Customer customer) {
		List<OrderDetails> ord = orderServ.viewAllOrders(customer);
		ResponseEntity<List<OrderDetails>> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}


}

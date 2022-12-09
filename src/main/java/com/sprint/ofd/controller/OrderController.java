package com.sprint.ofd.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderServ;
	
	//controller calling orderService to add order
	@PostMapping("/order/add/")
	public ResponseEntity<OrderDetails> addOrder(Integer cartId) {
		OrderDetails ord = orderServ.addOrder(cartId);
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
	public ResponseEntity<String> removeOrder(@PathVariable Integer order) {
		String ord = orderServ.removeOrder(order);
		ResponseEntity<String> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	//controller calling orderService to view order
	@GetMapping("/order/viewOrder/{order}/")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable Integer order) {
		OrderDetails ord = orderServ.viewOrder(order);
		ResponseEntity<OrderDetails> response = new ResponseEntity<>(ord, HttpStatus.OK); 
		return response;
	}
	
	@GetMapping("/order/view/totalCost/{orderId}")
	public ResponseEntity<Double> viewTotalCost(@PathVariable Integer orderId) {
		double totalCost = orderServ.viewTotalCost(orderId);
		ResponseEntity<Double> response = new ResponseEntity<>(totalCost, HttpStatus.OK); 
		return response;
	
	}


}

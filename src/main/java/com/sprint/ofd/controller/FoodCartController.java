package com.sprint.ofd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.service.ICartService;

@RestController
public class FoodCartController {
	
	@Autowired
	ICartService cartServ;
	
	
	
	//controller calling foodCartService to add Item to cart
	@PostMapping("/cart/additem/{cart}/")
	public ResponseEntity<FoodCart> addItemToCart(@Valid @PathVariable("cart") FoodCart cart) {
		FoodCart food = cartServ.addItemToCart(cart);
		ResponseEntity<FoodCart> response = new ResponseEntity<>(food, HttpStatus.OK); 
		return response;
		
	}
	//controller calling foodCartService to increase quantity	
	@PutMapping("/cart/increaseQuantity/{cart}/{item}/{quant}/")
	public ResponseEntity<FoodCart> increaseQuantity(@Valid @PathVariable("cart") FoodCart cart,@Valid @PathVariable("item") Item item,@Valid @PathVariable("quant") int quantity) {
		FoodCart food = cartServ.increaseQuantity(cart, item,quantity);
		ResponseEntity<FoodCart> response = new ResponseEntity<>(food, HttpStatus.OK); 
		return response;
	}
	//controller calling foodCartService to reduce quantity
	@PutMapping("/cart/reduceQuantity/{cart}/{item}/{quant}/")
	public ResponseEntity<FoodCart> reduceQuantity(@Valid @PathVariable("cart") FoodCart cart,@Valid @PathVariable("item") Item item,@Valid @PathVariable("quant") int quantity) {
		FoodCart food = cartServ.reduceQuantity(cart, item,quantity);
		ResponseEntity<FoodCart> response = new ResponseEntity<>(food, HttpStatus.OK); 
		return response;
	}
	//controller calling foodCartService to delete Item from cart
	@DeleteMapping("/cart/delete/item/{cart}/{item}")
	public ResponseEntity<FoodCart> removeItem(@Valid @PathVariable("cart") FoodCart cart,@Valid @PathVariable("item") Item item) {
		FoodCart food = cartServ.removeItem(cart, item);
		ResponseEntity<FoodCart> response = new ResponseEntity<>(food, HttpStatus.OK);
		return response;
	}
	
	//controller calling foodCartService to clear cart
	@DeleteMapping("/cart/delete/all/{cart}")
	public ResponseEntity<FoodCart> clearCart(@Valid @PathVariable FoodCart cart) {
		FoodCart food = cartServ.clearCart(cart);
		ResponseEntity<FoodCart> response = new ResponseEntity<>(food, HttpStatus.OK); 
		return response;
	}

}

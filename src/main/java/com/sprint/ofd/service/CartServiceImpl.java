package com.sprint.ofd.service;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;

import org.apache.logging.log4j.EventLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.repository.ICartRepository;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	ICartRepository cartRepo;
	private Logger logger=LogManager.getLogger();
	
	//add item to cart in db
	
	@Override
	public FoodCart addItemToCart(FoodCart cart) {
		
		FoodCart newCart= cartRepo.save(cart);
		logger.info("Item Added to cart");
		
		return newCart;
	}
	
	
	//increasing quantity in cart db
	@Override
	public FoodCart increaseQuantity(FoodCart cart,Item item,int quantity) {
		Optional<FoodCart> food=cartRepo.findById(cart.getCartId());
		FoodCart car=food.get();
		car.setQuantity(quantity);
		car=cartRepo.save(car);
		logger.info("Item quantity changed in cart");
		return car;
	}
	
	//reducing quantity in cart db
	@Override
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity) {
		Optional<FoodCart> food=cartRepo.findById(cart.getCartId());
		FoodCart car=food.get();
		car.setQuantity(quantity);
		car=cartRepo.save(car);
		logger.info("Item quantity changed in cart");
		return car;
	}
	
	//removing item from cart
	@Override
	public FoodCart removeItem(FoodCart cart,Item item) {
		Optional<FoodCart> food=cartRepo.findById(cart.getCartId());
		FoodCart car=food.get();
		car.getItemList().remove(item);
		car=cartRepo.save(car);
		logger.info("Item removed from cart");
		
		return car;
		
	}
	
	
	//deleting all items from cart
	@Override
	public FoodCart clearCart(FoodCart cart) {
		Optional<FoodCart> food=cartRepo.findById(cart.getCartId());
		FoodCart car=food.get();
		car.setItemList(null);
		
		return car;
	}


}

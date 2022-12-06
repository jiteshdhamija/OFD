package com.sprint.ofd.service;

import java.util.List;

import java.util.Optional;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.dto.CartInputDto;
import com.sprint.ofd.exceptions.CartNotFoundException;
import com.sprint.ofd.repository.ICartRepository;
import com.sprint.ofd.repository.IItemRepository;

@Service
public class CartServiceImpl implements ICartService {
	
	@Autowired
	ICartRepository cartRepo;
	@Autowired
	IItemRepository itemRepo;
	
	private Logger logger=LogManager.getLogger();
	
	//add item to cart in db
	@Override
	public FoodCart addItemToNewCart(int itemId) {
		
		Optional<Item> opt=itemRepo.findById(itemId);
		Item item=new Item();
		if(opt.isPresent()) {
		FoodCart cart=new FoodCart();
		List<Item> itemList=cart.getItemList();
		item=opt.get();
		itemList.add(item);
		cartRepo.save(cart);
		return cart;
		}
		else
			throw new CartNotFoundException("cart not found");
	}
	
	
	
	@Override
	public FoodCart addItemToCart(int itemId,int cartId) {
		Optional<FoodCart> opt=cartRepo.findById(cartId);
		FoodCart cart=new FoodCart();
		
		if(opt.isPresent()) {
			cart=opt.get();
			List<Item> itemList=cart.getItemList();
			Optional<Item> it=itemRepo.findById(itemId);
			Item item= it.get();
			itemList.add(item);
			cartRepo.save(cart);
			return cart;
		}
		else
			throw new CartNotFoundException("cart not found");
	}
	
	
	
	@Override
	public FoodCart increaseQuantity(int cartId,int itemId,int quantity) {
		Optional<FoodCart> food=cartRepo.findById(cartId);
		FoodCart car=food.get();
		List<Item> it=car.getItemList();
		
		for(Item i:it) {
			if(i.getItemId()==itemId) {
				i.setQuantity(quantity);
			}
		}
		car=cartRepo.save(car);
		logger.info("Item quantity changed in cart");
		return car;
	}
	
	//reducing quantity in cart db
	@Override
	public FoodCart reduceQuantity(int cartId,int itemId,int quantity) {
		Optional<FoodCart> food=cartRepo.findById(cartId);
		FoodCart car=food.get();
		List<Item> it=car.getItemList();
		
		for(Item i:it) {
			if(i.getItemId()==itemId) {
				i.setQuantity(quantity);
			}
		}
		car=cartRepo.save(car);
		logger.info("Item quantity changed in cart");
		return car;
	}
	
	//removing item from cart
	@Override
	public FoodCart removeItem(int cartId,int itemId) {
		Optional<FoodCart> food=cartRepo.findById(cartId);
		FoodCart car=food.get();
		Optional<Item> it=itemRepo.findById(itemId);
		Item item=it.get();
		car.getItemList().remove(item);
		car=cartRepo.save(car);
		logger.info("Item removed from cart");
		
		return car;
		
	}
	
	
	//deleting all items from cart
	@Override
	public FoodCart clearCart(int cartId) {
		Optional<FoodCart> food=cartRepo.findById(cartId);
		FoodCart car=food.get();
		car.setItemList(null);
		
		return car;
	}


	
	


}

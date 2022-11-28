package com.sprint.ofd.service;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.dto.CartInputDto;


public interface ICartService {

	
	public FoodCart increaseQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart reduceQuantity(FoodCart cart,Item item,int quantity);
	public FoodCart removeItem(FoodCart cart,Item item);
	public FoodCart clearCart(FoodCart cart);
	public FoodCart addItemToCart(CartInputDto cart);
	
	
}

package com.sprint.ofd.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.dto.CartInputDto;


public interface ICartService {

	
	public FoodCart increaseQuantity(int cartId,int itemId,int quantity);
	public FoodCart reduceQuantity(int cartId,int itemId,int quantity);
	public FoodCart removeItem(int cartId,int itemId);
	public FoodCart clearCart(int cartId);
	public FoodCart addItemToCart(int itemId,int cartId);
	public FoodCart addItemToNewCart(int itemId);
	public List<FoodCart> viewAll();
	public String removeCart(int cart);
	
	
}

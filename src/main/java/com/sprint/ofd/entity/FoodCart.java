package com.sprint.ofd.entity;

import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class FoodCart {
		
	@Id
	@GeneratedValue
	private int cartId;
	
	private int quantity;
	
	
	//private Customer customer;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_item_fk")
	private List<Item> itemList;

}

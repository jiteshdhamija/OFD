package com.sprint.ofd.entity;

import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class FoodCart {
		
	@Id
	@GeneratedValue
	private int cartId;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="cart_cust_fk")
	private Customer customer;
	@OneToMany(cascade=CascadeType.MERGE)
	@JoinColumn(name="cart_item_fk")
	private List<Item> itemList;

}

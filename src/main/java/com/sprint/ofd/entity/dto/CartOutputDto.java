package com.sprint.ofd.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.Item;

import lombok.Data;

@Data
public class CartOutputDto {
	
	private int cartId;
	private Customer customer;
	private List<Item> itemList;

}

package com.sprint.ofd.entity.dto;

import java.util.List;



import com.sprint.ofd.entity.Restaurant;

import lombok.Data;

@Data
public class ItemOutputDto {

	private int itemId;
    
	private String itemName;

	private double cost;
	private List<Restaurant> restaurants;
}

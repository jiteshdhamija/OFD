package com.sprint.ofd.entity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.sprint.ofd.entity.Restaurant;

import lombok.Data;


@Entity
@Data
public class Item {
	
	@Id
    @GeneratedValue
	private int itemId;
    @NotNull
	private String itemName;
	//private Category category;
	//private int quantity;
	@NotNull
	private double cost;
	//private List<Restaurant> restaurants;

}

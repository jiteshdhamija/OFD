package com.sprint.ofd.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.sprint.ofd.entity.Address;
import com.sprint.ofd.entity.Item;

public class RestaurantOutputDto {

	
	@NotNull
	private String restaurantName;
	
	@NotNull
	private long contactNumber;
	//@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="rest_addr_fk")
	private Address address;
	
	
}

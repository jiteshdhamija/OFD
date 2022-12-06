package com.sprint.ofd.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="item_category_fk")
    private Category category;
	private int quantity;
	@NotNull
	private double cost;
	

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "res_item_list", joinColumns = { @JoinColumn(name = "restaurant_id") }, inverseJoinColumns = {
	@JoinColumn(name = "item_id") })
	private List<Restaurant> restaurants;

}

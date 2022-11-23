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
//import com.sprint.ofd.entity.Address;
//import com.sprint.ofd.entity.Item;
import lombok.Data;

@Data
@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue
	private int restaurantId;
	@NotNull
	private String restaurantName;
	private String managerName;
	@NotNull
	private long contactNumber;
	//@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="rest_addr_fk")
	private Address address;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE },fetch = FetchType.EAGER)
	@JoinTable(name = "res_item_list", joinColumns = { @JoinColumn(name = "restaurant_id") }, inverseJoinColumns = {
	@JoinColumn(name = "item_id") })
	private List<Item> itemList;

}

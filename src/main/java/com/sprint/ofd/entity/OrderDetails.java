package com.sprint.ofd.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity

public class OrderDetails {

	@Id
	@GeneratedValue
	private Integer orderId;
	private LocalDateTime orderDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_cart_fk")
	private FoodCart cart;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String orderStatus;
}

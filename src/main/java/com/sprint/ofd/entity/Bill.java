package com.sprint.ofd.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Bill {
	
	@Id
	private Integer billId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_bill_fk")
	private OrderDetails order;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_bill_fk")
	private Customer customer;
	
	private int totalItem;
	@NotNull
	@NotEmpty
	@NotBlank
	private double totalCost;
	LocalDate billDate;

}

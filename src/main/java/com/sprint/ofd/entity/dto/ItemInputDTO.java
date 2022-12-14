package com.sprint.ofd.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ItemInputDTO {
	
	@Id
    @GeneratedValue
	private int itemId;
	
    @NotNull
	private String itemName;
	private String categoryName;
	
	@NotNull
	private double cost;
	

	

}

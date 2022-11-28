package com.sprint.ofd.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sprint.ofd.entity.Customer;
import com.sprint.ofd.entity.Item;

import lombok.Data;

@Data
public class CartInputDto {
	private List<Item> itemList;
}

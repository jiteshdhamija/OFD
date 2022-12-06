package com.sprint.ofd.entity.dto;

import java.util.List;

import com.sprint.ofd.entity.Item;

import lombok.Data;


@Data
public class CartInputDto {
	private List<Item> itemList;

}

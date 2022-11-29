package com.sprint.ofd.service;
import java.util.List;

import com.sprint.ofd.entity.Category;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.entity.dto.ItemInputDTO;
import com.sprint.ofd.entity.dto.ItemOutputDto;
import com.sprint.ofd.exceptions.ItemNotFoundException;

public interface IItemService {
	
	public Item addItem(ItemInputDTO item);
	public Item viewItem(Integer id)throws ItemNotFoundException;
	public Item updateItem(int id, Item item)throws ItemNotFoundException;
	public Item removeItem(int id)throws ItemNotFoundException;
	public List<Item> viewAllItems()throws ItemNotFoundException;
	public List<Item> viewAllItemsByRes(int resId);
	public List<ItemOutputDto> viewAllItemsByCat(int catId);
	public List<ItemOutputDto> viewAllItemsByName(String name);
	

}

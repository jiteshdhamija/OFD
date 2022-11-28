package com.sprint.ofd.service;
import java.util.List;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.ItemRestDTO;
import com.sprint.ofd.exceptions.ItemNotFoundException;

public interface IItemService {
	
	public Item addItem(ItemRestDTO item);
	public Item viewItem(int id)throws ItemNotFoundException;
	public Item updateItem(int id, Item item)throws ItemNotFoundException;
	public Item removeItem(int id)throws ItemNotFoundException;
	public List<Item> viewAllItems()throws ItemNotFoundException;
//	public List<Item> viewAllItems(Restaurant res);
//	public List<Item> viewAllItems(Category cat);
//	public List<Item> viewAllItemsByName(String name);

}

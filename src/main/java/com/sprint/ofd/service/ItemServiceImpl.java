package com.sprint.ofd.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Category;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.entity.dto.ItemInputDTO;
import com.sprint.ofd.entity.dto.ItemOutputDto;
import com.sprint.ofd.exceptions.ItemNotFoundException;
import com.sprint.ofd.exceptions.RestaurantNotFoundException;
import com.sprint.ofd.repository.ICategoryRepository;
import com.sprint.ofd.repository.IItemRepository;
import com.sprint.ofd.repository.IRestaurantRepository;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	IItemRepository itemRepo;
	@Autowired
	ICategoryService catServ;
	@Autowired
	IRestaurantRepository resRepo;
	
	
	
	private Logger logger = LogManager.getLogger();
    
	/*
     * Here we are adding items to the database
     */
	@Override
	public Item addItem(ItemInputDTO item) {
		
		Item i=new Item();
		i.setItemName(item.getItemName());
		i.setCost(item.getCost());
		i.setCategory(catServ.viewCategory( item.getCategoryName()));
		Item newItem = itemRepo.save(i);
		logger.info("item added with unique id");
		return newItem;
	}
	/*
     * Here we are viewing item to the database according to the respective itemId
     */
	@Override
	public Item viewItem(Integer id) {
		Optional<Item> opt = itemRepo.findById(id);
		logger.info("sending find request to repository");
		Item itm=null;
		if(opt.isPresent()) {
			logger.info("item found with given id");
			itm = opt.get();
		}
		else
			throw new ItemNotFoundException("Item with this id not found");
		return itm;
	}
	/*
     * Here we are updating item to the database according to the respective itemId
     */
	@Override
	public Item updateItem(int id, Item item) {
		Optional<Item> opt = itemRepo.findById(id);
		if(opt.isPresent()) {
			logger.info("item found with given id");
			itemRepo.save(item);
		}
		else
			throw new ItemNotFoundException("Item with this id not found");
		return item;
	}
	/*
     * Here we are removing item from the database according to the respective itemId
     */
	@Override
	public Item removeItem(int id) {
		Optional<Item> opt = itemRepo.findById(id);
		logger.info("sending find request to repository");
		Item itm=null;
		if(opt.isPresent()) {
			logger.info("item found with given id");
			itm = opt.get();
			itemRepo.deleteById(id);
		}		
		else 
			throw new ItemNotFoundException("Item with this id not found");
		return itm;
	}
	/*
     * Here we are viewing all the items from the database according to the respective itemId
     */
	@Override
	public List<Item> viewAllItems() {
		List<Item> itemList = itemRepo.findAll();
		logger.info("items found with respective id");
		return itemList;
	}
	@Override
	public List<Item> viewAllItemsByRes(int restId) {
		Optional<Restaurant> res=resRepo.findById(restId);
		Restaurant r=null;
	
		if(res.isPresent())
			{r=res.get();
			
			return r.getItemList();}
		else		
			throw new RestaurantNotFoundException("Restaurant not Found with this ID");
			
	}
	@Override
	public List<ItemOutputDto> viewAllItemsByCat(int catId) {
		List<Item> item=itemRepo.getItemByCat(catId);
		List<ItemOutputDto> idto=new ArrayList<ItemOutputDto>();
		ItemOutputDto chan=new ItemOutputDto();
		for(Item a : item) {
			chan.setCost(a.getCost());
			chan.setItemId(a.getItemId());
			chan.setItemName(a.getItemName());
			chan.setRestaurants(a.getRestaurants());
			idto.add(chan);
		}
		if (idto.isEmpty())
			throw new ItemNotFoundException("No items found in this Category, try something else;");
		else	
			return idto;
	}
	@Override
	public List<ItemOutputDto> viewAllItemsByName(String name) {
		List<Item> item=itemRepo.getItemByName(name);
		List<ItemOutputDto> idto=new ArrayList<ItemOutputDto>();
		ItemOutputDto chan=new ItemOutputDto();
		for(Item a : item) {
			chan.setCost(a.getCost());
			chan.setItemId(a.getItemId());
			chan.setItemName(a.getItemName());
			chan.setRestaurants(a.getRestaurants());
			idto.add(chan);
		}
		if (idto.isEmpty())
			throw new ItemNotFoundException("Item with the same name not found, Try something else;");
		else
			return idto;
	}
}



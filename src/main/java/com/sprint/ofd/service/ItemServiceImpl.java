package com.sprint.ofd.service;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.ofd.entity.Category;
import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.ItemRestDTO;
import com.sprint.ofd.repository.ICategoryRepository;
import com.sprint.ofd.repository.IItemRepository;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	IItemRepository itemRepo;
	@Autowired
	ICategoryService catServ;
	
	private Logger logger = LogManager.getLogger();
    
	/*
     * Here we are adding items to the database
     */
	@Override
	public Item addItem(ItemRestDTO item) {
		
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
	public Item viewItem(int id) {
		Optional<Item> opt = itemRepo.findById(id);
		logger.info("sending find request to repository");
		Item itm=null;
		if(opt.isPresent()) {
			logger.info("item found with given id");
			itm = opt.get();
		}
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
}



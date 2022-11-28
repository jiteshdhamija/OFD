package com.sprint.ofd.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.ItemRestDTO;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.service.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	IItemService itmServ;
	
	@PostMapping("/item/add")
	ResponseEntity<Item> addItem(@RequestBody ItemRestDTO item) {
		System.out.println(item);
		Item newItem = itmServ.addItem(item);
		System.out.println(newItem);
		ResponseEntity<Item> response = new ResponseEntity<>(newItem, HttpStatus.CREATED); 
		return response;
	};
	
	@DeleteMapping("/item/remove/{itemId}")
    ResponseEntity<Item> removeItem(@PathVariable int itemId) {
    	Item itm = itmServ.removeItem(itemId);
    	return new ResponseEntity<>(itm, HttpStatus.OK);
    };
    
    @GetMapping("/item/view/{itemId}")
    ResponseEntity<Item> viewItem(@PathVariable int itemId) {
    	Item itm = itmServ.viewItem(itemId);
    	return new ResponseEntity<>(itm, HttpStatus.OK);
    };

    @GetMapping("/items/viewAll")
    ResponseEntity<List<Item>> viewAllItems() {
	List<Item> itemList =itmServ.viewAllItems();
	return new ResponseEntity<>(itemList, HttpStatus.OK);
};

 /*   @GetMapping("/restaurant/view/{restaurantName}")
    ResponseEntity<Restaurant> viewRestaurant(@PathVariable String restaurantName) {
	Restaurant res = restServ.viewRestaurant(restaurantName);
	return new ResponseEntity<>(res, HttpStatus.OK); 
};
*/

}




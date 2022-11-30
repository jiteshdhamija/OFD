package com.sprint.ofd.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.entity.dto.ItemInputDTO;
import com.sprint.ofd.entity.dto.RestaurantInputDto;
import com.sprint.ofd.entity.dto.RestaurantOutputDto;
import com.sprint.ofd.service.IRestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	IRestaurantService restServ;
	
	@PostMapping("/restaurant/add")
	ResponseEntity<Restaurant> addRestaurant(@RequestBody RestaurantInputDto res) {
		System.out.println(res);
		Restaurant newRes = restServ.addRestaurant(res);
		System.out.println(newRes);
		ResponseEntity<Restaurant> response = new ResponseEntity<>(newRes, HttpStatus.CREATED); 
		return response;
	};
	
	@DeleteMapping("/restaurant/remove/{restaurantId}")
    ResponseEntity<Restaurant> removeRestaurant(@PathVariable int restaurantId) {
    	Restaurant res = restServ.removeRestaurant(restaurantId);
    	return new ResponseEntity<>(res, HttpStatus.OK);
    };
    

    @GetMapping("/restaurants/viewAll")
    ResponseEntity<List<Restaurant>> viewAllRestauants() {
	List<Restaurant> restList =restServ.viewAllRestaurants();
	return new ResponseEntity<>(restList, HttpStatus.OK);
};

    @GetMapping("/restaurant/view/{restaurantName}")
    ResponseEntity<Restaurant> viewRestaurant(@PathVariable String restaurantName) {
	Restaurant res = restServ.viewRestaurant(restaurantName);
	return new ResponseEntity<>(res, HttpStatus.OK); 
};

 @GetMapping("/Restaurant/viewNearByRestaurant/{area}")
    ResponseEntity<List<RestaurantOutputDto>> viewNearByRestaurant(@PathVariable("area") String area) {
    	List<RestaurantOutputDto> restList =restServ.viewByArea(area);
    	return new ResponseEntity<>(restList, HttpStatus.OK);    
};


    @PutMapping("/restaurant/update/{restaurantId}")
    ResponseEntity<Restaurant> updateRestaurant(@PathVariable int restaurantId, @RequestBody RestaurantInputDto res) {
	Restaurant updatedRest = restServ.updateRestaurant(restaurantId, res);
	return new ResponseEntity<>(updatedRest, HttpStatus.OK);
};
	@GetMapping("/restaurant/view/id/{resId}")
	ResponseEntity<RestaurantOutputDto> viewRestaurantById(@PathVariable int resId) {
		RestaurantOutputDto res = restServ.findById(resId);
		return new ResponseEntity<>(res, HttpStatus.OK); 
};

	@PutMapping("/restaurant/update/itemlist/{itemList}/{restId}")
	ResponseEntity<List<Item>> updateItemList(@PathVariable List<ItemInputDTO> itemList,@PathVariable int restId) {
		List<Item> list = restServ.updateItemList(itemList,restId);
		return new ResponseEntity<>(list, HttpStatus.OK); 
};

@PutMapping("/restaurant/add/itemlist/{itemId}/{restId}")
	ResponseEntity<List<Item>> updateItemList(@PathVariable int itemId,@PathVariable int restId) {
		List<Item> list = restServ.addItemToList(itemId,restId);
		return new ResponseEntity<>(list, HttpStatus.OK); 
};

@GetMapping("/restaurant/view/itemlist/{resId}")
	ResponseEntity<List<Item>> viewItemList(@PathVariable int resId) {
		List<Item> list = restServ.viewItemList(resId);
		return new ResponseEntity<>(list, HttpStatus.OK); 
};


}

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

import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.service.IRestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	IRestaurantService restServ;
	
	@PostMapping("/restaurant/add")
	ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant res) {
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
/*
    @GetMapping("/restaurant/view/{restaurantName}")
    ResponseEntity<Restaurant> viewRestaurant(@PathVariable String restaurantName) {
	Restaurant res = restServ.viewRestaurant(restaurantName);
	return new ResponseEntity<>(res, HttpStatus.OK); 
};

 @GetMapping("/Restaurant/viewNearByRestaurant/{area}")
    ResponseEntity<List<Restaurant>> viewNearByRestaurant(@PathVariable("area") String area) {
    	List<Restaurant> restList =resServ.viewNearByRestaurant(area);
    	return new ResponseEntity<>(restList, HttpStatus.OK);    
};
*/

    @PutMapping("/restaurant/update/{restaurantId}")
    ResponseEntity<Restaurant> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurant res) {
	Restaurant updatedRest = restServ.updateRestaurant(restaurantId, res);
	return new ResponseEntity<>(updatedRest, HttpStatus.OK);
};


}

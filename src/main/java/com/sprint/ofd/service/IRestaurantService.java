package com.sprint.ofd.service;
import java.util.List;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.entity.dto.RestaurantInputDto;
import com.sprint.ofd.entity.dto.RestaurantOutputDto;
import com.sprint.ofd.exceptions.RestaurantNotFoundException;
public interface IRestaurantService {
	
	public Restaurant addRestaurant(RestaurantInputDto res);
	public Restaurant removeRestaurant(int restaurantId) throws RestaurantNotFoundException;
	public List<Restaurant> viewAllRestaurants() throws RestaurantNotFoundException;
	public Restaurant viewRestaurant(String restaurantName) throws RestaurantNotFoundException;
	public Restaurant updateRestaurant(int restaurantId,RestaurantInputDto res) throws RestaurantNotFoundException;
	public List<RestaurantOutputDto> viewByArea(String area);
	public RestaurantOutputDto findById(int resId);
	

}

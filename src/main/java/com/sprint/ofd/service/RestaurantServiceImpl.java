package com.sprint.ofd.service;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.ofd.repository.IRestaurantRepository;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.exceptions.RestaurantNotFoundException;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	IRestaurantRepository resRepo;
	
	private Logger logger = LogManager.getLogger();
    /*
     * Here we are adding restaurant to the database
     */
	@Override
	public Restaurant addRestaurant(Restaurant res) {
		Restaurant newRes = resRepo.save(res);      
		logger.info("restaurant added with unique id");
		return newRes; 
	}
	/*
     * Here we are removing restaurant from the database according to the respective resturantId
     */
	@Override
	public Restaurant removeRestaurant(int restaurantId) throws RestaurantNotFoundException {
		logger.info("sending get request to repository");
		Optional<Restaurant> opt = resRepo.findById(restaurantId); 
		Restaurant rest = null;
		if (opt.isPresent()) { // if restaurant is present
			logger.info("restaurant found with given id");
			rest = opt.get();
			resRepo.deleteById(restaurantId); 

			return rest;
		}

		else {
			throw new RestaurantNotFoundException("Restaurant ID NOT AVAILABLE ");  
		}
	}
	/*
     * Here we are viewing all the restaurant from the database
     */
	@Override
	public List<Restaurant> viewAllRestaurants() {
		List<Restaurant> resList = resRepo.findAll();
		logger.info("restaurants found with respective id");
		return resList;
		
	}
	/*
     * Here we are viewing the restaurant from the database according to the respective restaurantName
     */
	@Override
	public Restaurant viewRestaurant(String restaurantName) {
		Restaurant res = resRepo.findByRestaurantName(restaurantName);
		return res;
	}
	/*
     * Here we are updating restaurant to the database according to the respective restaurantId
     */
	@Override
	public Restaurant updateRestaurant(int restaurantId, Restaurant res) throws RestaurantNotFoundException{
		Optional<Restaurant> opt = resRepo.findById(restaurantId);
		if (opt.isPresent()) {
			logger.info("restaurant found with given id");
			resRepo.save(res);
		return res;
		}
		else {
			throw new RestaurantNotFoundException("Restaurant ID NOT AVAILABLE ");
		}
	}	

}

package com.sprint.ofd.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.ofd.repository.IRestaurantRepository;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.entity.dto.RestaurantInputDto;
import com.sprint.ofd.entity.dto.RestaurantOutputDto;
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
	public Restaurant addRestaurant(RestaurantInputDto res) {
		Restaurant newRes=new Restaurant();
		newRes.setAddress(res.getAddress());
		newRes.setContactNumber(res.getContactNumber());
		newRes.setManagerName(res.getManagerName());
		newRes.setRestaurantName(res.getRestaurantName());
		newRes = resRepo.save(newRes);      
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
	public Restaurant updateRestaurant(int restaurantId, RestaurantInputDto res) throws RestaurantNotFoundException{
		Optional<Restaurant> opt = resRepo.findById(restaurantId);
		
		
		
		if (opt.isPresent()) {
			logger.info("restaurant found with given id");
			Restaurant newRes=new Restaurant();
			newRes.setAddress(res.getAddress());
			newRes.setContactNumber(res.getContactNumber());
			newRes.setManagerName(res.getManagerName());
			newRes.setRestaurantName(res.getRestaurantName());
			newRes = resRepo.save(newRes);  
			resRepo.save(newRes);
		return newRes;
		}
		else {
			throw new RestaurantNotFoundException("Restaurant Not found with given ID");
		}
	}	
	
	
	@Override
	public RestaurantOutputDto findById(int resId) {
		Optional<Restaurant> res=resRepo.findById(resId);
		Restaurant ress=null;
		RestaurantOutputDto rest=new RestaurantOutputDto();
		if(res.isPresent())
			{ress=res.get();
			rest.setAddress(ress.getAddress());
			rest.setContactNumber(ress.getContactNumber());
			rest.setRestaurantName(ress.getRestaurantName());
			return rest;}
		else
			throw new RestaurantNotFoundException("Restaurant not found with given ID");
	}
	@Override
	public List<RestaurantOutputDto> viewByArea(String area) {
		
		List<Restaurant> res=viewAllRestaurants();
		List<RestaurantOutputDto> restaurant=new ArrayList<>();
		RestaurantOutputDto dto=new RestaurantOutputDto();
		for(Restaurant r:res) {
			if(r.getAddress().getArea()==area) {
				dto.setAddress(r.getAddress());
				dto.setContactNumber(r.getContactNumber());
				dto.setRestaurantName(r.getRestaurantName());
				restaurant.add(dto);
			}
			else
				throw new RestaurantNotFoundException("Restaurant not found with given area");
		}
		return restaurant;
	}
	
};



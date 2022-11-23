package com.sprint.ofd;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sprint.ofd.entity.Restaurant;
import com.sprint.ofd.exceptions.RestaurantNotFoundException;
import com.sprint.ofd.service.IRestaurantService;

@SpringBootTest
class RestaurantServiceTest {
	
	@Autowired
	IRestaurantService restServ;
    
	@Disabled
	@Test
	void viewRestaurantTest() {
		Restaurant res = restServ.viewRestaurant("rajluxmi");
		assertEquals("rajluxmi", res.getRestaurantName());
		assertNotEquals("premadelight", res.getRestaurantName());
	}
	
	
	@Test
	void viewAllRestaurantsTest() throws RestaurantNotFoundException{
		List<Restaurant> resList = restServ.viewAllRestaurants();
		int totalRest= resList.size();
		assertEquals(0, totalRest);
	  //  Restaurant rest = resList.get(1);
		//assertEquals("rajluxmi", rest.getRestaurantName());
		//assertNotEquals(87878787, rest.getRestaurantId());
	}
	
	@Disabled
	@Test
	void removeRestaurantTest() throws RestaurantNotFoundException{
		Restaurant rest = restServ.removeRestaurant(82);
		assertEquals("string", rest.getRestaurantName());
		assertEquals(82, rest.getRestaurantId());
		assertEquals(0, rest.getContactNumber());
	}
}

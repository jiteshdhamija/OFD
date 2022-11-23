package com.sprint.ofd.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer> {

//	List<Restaurant> findNearByRestaurant(String area);

	Restaurant findByRestaurantName(String restaurantName);

}

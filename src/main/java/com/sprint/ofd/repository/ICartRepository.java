package com.sprint.ofd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.FoodCart;
import com.sprint.ofd.entity.Item;


@Repository
public interface ICartRepository extends JpaRepository<FoodCart,Integer>{
	

	

}

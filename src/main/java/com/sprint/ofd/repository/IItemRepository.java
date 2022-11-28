package com.sprint.ofd.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.ItemRestDTO;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {

	Item save(ItemRestDTO item);
	
	

}

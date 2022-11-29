package com.sprint.ofd.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Item;
import com.sprint.ofd.entity.dto.ItemOutputDto;


@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {	

	@Query(value="select * from item where item.item_category_fk=:catId", nativeQuery=true)
	List<Item> getItemByCat(@Param("catId") int empId);
	@Query(value="select * from item where item.item_name=:name", nativeQuery=true)
	List<Item> getItemByName(@Param("name")String name);
}

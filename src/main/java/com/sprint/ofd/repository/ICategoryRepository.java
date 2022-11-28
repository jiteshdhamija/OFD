package com.sprint.ofd.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.ofd.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

	

	

}

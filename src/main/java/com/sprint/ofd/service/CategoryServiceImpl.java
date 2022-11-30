package com.sprint.ofd.service;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint.ofd.entity.Category;
import com.sprint.ofd.exceptions.CategoryNotFoundException;
import com.sprint.ofd.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	ICategoryRepository catRepo;
	
	private Logger logger = LogManager.getLogger();
    
	/*
     * Here we are adding category to the database
     */
	@Override
	public Category addCategory(Category cat) {
		Category newCat = catRepo.save(cat); 
		logger.info("category added with unique id");
		return newCat;     
	}
	/*
     * Here we are updating category to the database according to the categoryId
     */
	@Override
	public Category updateCategory(int catId,Category cat) {
		Optional<Category> opt = catRepo.findById(catId);
		logger.info("sending get request to repository");
		if (opt.isPresent()) {
			logger.info("category found with given id");
			catRepo.save(cat);
		}
		return cat;	
	}
	/*
     * Here we are removing restaurant from the database according to the categoryId
     */
	@Override
	public Category removeCategory(int catId) {
		Optional<Category> opt = catRepo.findById(catId); 
		logger.info("sending get request to repository");
		Category rest = null;
		if (opt.isPresent()) {
			logger.info("category found with given id");
			rest = opt.get();
			catRepo.deleteById(catId); 
		}
			return rest;
		}
	/*
     * Here we are viewing category from the database according to the respective categoryName
     */
	@Override
	public Category viewCategory(String categoryName) {
		Category cat = catRepo.findByCategoryName(categoryName);
		logger.info("category found with given name");
		return cat;
	}
	/*
     * Here we are viewing all the categories from the database
     */
	@Override
	public List<Category> viewAllCategory() {
		List<Category> catList = catRepo.findAll();
		logger.info("categories found with respective id");
		return catList;	}
	
	
	
	@Override
	public Category viewById(int catId) {
		Optional<Category> cat= catRepo.findById(catId);
		Category category=new Category();
		if(cat.isPresent()) {
			category=cat.get();
			return category;
		}
		else
			throw new CategoryNotFoundException("Category Not Found");
		
	}

}

package com.sprint.ofd.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sprint.ofd.entity.Category;
import com.sprint.ofd.exceptions.CategoryNotFoundException;
import com.sprint.ofd.service.ICategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	ICategoryService catServ;
	
	/*
     * calls addCategory from service implementation class and adds categories in database
     */
	@PostMapping("/category/add")
	ResponseEntity<Category> addCategory(@Valid @RequestBody Category cat) {
		System.out.println(cat);
		Category newCat = catServ.addCategory(cat);
		System.out.println(newCat);
		ResponseEntity<Category> response = new ResponseEntity<>(newCat, HttpStatus.CREATED);  //201 CREATED
		return response;
	};
	/*
     * calls removeCategory from service implementation class and remove category in database according to categoryId
     */
	@DeleteMapping("/category/remove/{catId}")
	ResponseEntity<Category> removeCategory(@PathVariable int catId) throws CategoryNotFoundException {
		Category cat = catServ.removeCategory(catId);
		return new ResponseEntity<>(cat, HttpStatus.OK);    //200 OK
	};
	/*
     * calls viewAllCategory from service implementation class and view all categories in database 
     */
	@GetMapping("/category/viewAll")
	ResponseEntity<List<Category>> viewAllCategory() {
		List<Category> catList = catServ.viewAllCategory();
		return new ResponseEntity<>(catList, HttpStatus.OK);   //200 OK
	};
	/*
     * calls viewCategory from service implementation class and view category in database according to categoryName
     */
	@GetMapping("/category/view/{name}")
	ResponseEntity<Category> viewCategory(@PathVariable("name") String name) {
		Category cat = catServ.viewCategory(name);
		return new ResponseEntity<>(cat, HttpStatus.OK);    //200 OK
	};
	/*
     * calls updateCategory from service implementation class and update category in database according to categoryId
     */
	@PutMapping("/category/update/{catId}")
	ResponseEntity<Category> updateCategory(@PathVariable int catId, @RequestBody Category cat)
			throws CategoryNotFoundException {
		Category updatedCat = catServ.updateCategory(catId, cat);
		return new ResponseEntity<>(updatedCat, HttpStatus.OK);     //200 OK
	}; 
	
	@GetMapping("/category/view/id/{catId}")
	ResponseEntity<Category> viewCatById(@PathVariable int catId){
		Category cat=catServ.viewById(catId);
		return new ResponseEntity<>(cat,HttpStatus.OK);
		
	}


}

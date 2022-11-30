package com.sprint.ofd.service;
import java.util.List;
import com.sprint.ofd.entity.Category;

public interface ICategoryService {
	
	public Category addCategory(Category cat);
	public Category updateCategory(int catId,Category cat);
	public Category removeCategory(int catId);
	public Category viewCategory(String categoryName);
	public List<Category> viewAllCategory();
	public Category viewById(int catId);

}

/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.Category;

/**
 * @author jeetendra.patidar
 *
 */
public interface CategoryDao {

	public Category getCatoryById(Long categoryId);
	
	public List<Category> getCategories(); 
	
	public Boolean saveCategory(Category category);
	
	public Boolean updateCategory(Category category);
	
	public Boolean deleteCategory(Category category);
}

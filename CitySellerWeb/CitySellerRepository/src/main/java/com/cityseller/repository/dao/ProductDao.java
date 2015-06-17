/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.Product;

/**
 * @author jeetendra.patidar
 *
 */
public interface ProductDao {

	public Product getProductById(Long productId);
	
	public List<Product> getAllProducts(); 
	
	public Boolean saveProduct(Product product);
	
	public Boolean updateProduct(Product product);
	
	public Boolean deleteProduct(Product product);
}

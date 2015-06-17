/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.ProductFeature;

/**
 * @author jeetendra.patidar
 *
 */
public interface ProductFeatureDao {

	public ProductFeature getProductFeatureById(Long productFeatureId);
	
	public List<ProductFeature> getAllProductFeatures(); 
	
	public Boolean saveProductFeature(ProductFeature productFeature);
	
	public Boolean updateProductFeature(ProductFeature productFeature);
	
	public Boolean deleteProductFeature(ProductFeature productFeature);
	
	
	
	
	
}

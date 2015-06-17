/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.Features;

/**
 * @author jeetendra.patidar
 *
 */
public interface FeatureDao {

	public Features getFeatureById(Long featureId);
	
	public List<Features> getAllFeatures(); 
	
	public Boolean saveFeature(Features features);
	
	public Boolean updateFeature(Features features);
	
	public Boolean deleteFeature(Features features);
}

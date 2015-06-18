/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.City;
import com.cityseller.repository.domain.CityArea;

/**
 * @author pavan.gupta
 *
 */
public interface CityAreaDao {

	public CityArea getCityAreaById(Long cityAreaId);
	
	public List<CityArea> getCityAreas(); 
	
	public Boolean saveCityArea(CityArea cityArea);
	
	public Boolean updateCityArea(CityArea cityArea);
	
	public Boolean deleteCityArea(CityArea cityArea);
}

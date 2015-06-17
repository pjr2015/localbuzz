/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.City;

/**
 * @author pavan.gupta
 *
 */
public interface CityDao {

	public City getCityById(Long cityId);
	
	public List<City> getCities(); 
	
	public Boolean saveCity(City city);
	
	public Boolean updateCity(City city);
	
	public Boolean deleteCity(City city);
}

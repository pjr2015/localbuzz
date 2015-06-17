/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.Country;

/**
 * @author pavan.gupta
 *
 */
public interface CountryDao {

	public Country getCountryById(Long countryId);
	
	public List<Country> getCountries(); 
	
	public Boolean saveCountry(Country country);
	
	public Boolean updateCountry(Country country);
	
	public Boolean deleteCountry(Country country);
}

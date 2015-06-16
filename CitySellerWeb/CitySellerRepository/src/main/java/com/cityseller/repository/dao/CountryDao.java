package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.Country;

public interface CountryDao {

	public List<Country> getCountryList(); 
	
	public Country getCountryById();
	
	public boolean addCountry(Country country);
	
	public boolean deleteCountry(Country country);
	
	public boolean updateCountry(Country country);
}

/**
 * 
 */
package com.cityseller.repository.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cityseller.repository.dao.CountryDao;
import com.cityseller.repository.domain.Country;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class CountryDaoImpl implements CountryDao {
	
private final static Logger logger = LoggerFactory.getLogger(CountryDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CountryDao#getCountryById(java.lang.Long)
	 */
	public Country getCountryById(Long countryId) {
		logger.info("CountryDaoImpl-getCountryById-START for countryId:"+countryId);
		Country country=null;
		try{
			if(countryId!=null && (!countryId.equals(""))){
				country= entityManager.find(Country.class, countryId);
			}
		}catch (Exception e) {
			logger.error("CountryDaoImpl-getCountryById-ERROR for countryId:"+countryId ,e);
		}
		logger.info("CountryDaoImpl-getCountryById-END for countryId:"+countryId);
		return country;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CountryDao#getCountries()
	 */
	public List<Country> getCountries() {
		logger.info("CountryDaoImpl-getCountries-START");
		List<Country> countries =null;
		try{
		CriteriaQuery<Country> criteria = entityManager.getCriteriaBuilder().createQuery(Country.class);
	    criteria.select(criteria.from(Country.class));
	    countries = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("CountryDaoImpl-getCountries-ERROR",e);
		}
		logger.info("CountryDaoImpl-getCountries-END");
	    return countries;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CountryDao#saveCountry(com.cityseller.repository.domain.Country)
	 */
	public Boolean saveCountry(Country country) {
		logger.info("CountryDaoImpl-saveCountry-START");
		Boolean isSave=false;
		try{
			if(country != null){
				logger.info("CountryDaoImpl-saveCountry-saving country  for: "+country.toString());
				entityManager.persist(country);  //saves the country object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("CountryDaoImpl-saveCountry-country  object is null");
			}
		}catch(Exception e){
			logger.error("CountryDaoImpl-saveCountry-ERROR",e);
		}
		logger.info("CountryDaoImpl-saveCountry-END ");
		return isSave;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CountryDao#updateCountry(com.cityseller.repository.domain.Country)
	 */
	public Boolean updateCountry(Country country) {
		logger.info("CountryDaoImpl-updateCountry-START");
		Boolean isUpdated=false;
		try{
			if(country != null){
				logger.info("CountryDaoImpl-updateCountry-updating country for: "+country.toString());
				entityManager.merge(country);  //saves the userDetails object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("CountryDaoImpl-updateCountry-vendor country is null");
			}
		}catch(Exception e){
			logger.error("CountryDaoImpl-updateCountry-ERROR",e);
		}
		logger.info("CountryDaoImpl-updateCountry-END ");
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CountryDao#deleteCountry(com.cityseller.repository.domain.Country)
	 */
	public Boolean deleteCountry(Country country) {
		logger.info("CountryDaoImpl-deleteCountry-START");
		Boolean isDeleted=false;
		try{
			if(country != null){
				country=getCountryById(country.getCountryId());
				logger.info("CountryDaoImpl-deleteCountry-deleteing country for: "+country.toString());
				entityManager.getLockMode(country);
				entityManager.remove(country);  //saves the Vendor object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("CountryDaoImpl-deleteCountry-country  object is null");
			} 
		}catch(Exception e){
			logger.error("CountryDaoImpl-deleteCountry-ERROR",e);
		}
		logger.info("CountryDaoImpl-deleteCountry-END ");
		return isDeleted;
	}

}

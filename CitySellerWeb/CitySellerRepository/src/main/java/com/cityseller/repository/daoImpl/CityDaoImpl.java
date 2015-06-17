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

import com.cityseller.repository.dao.CityDao;
import com.cityseller.repository.domain.City;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class CityDaoImpl implements CityDao {
	
private final static Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityDao#getCityById(java.lang.Long)
	 */
	public City getCityById(Long cityId) {
		logger.info("CityDaoImpl-getCityById-START for cityId:"+cityId);
		City city=null;
		try{
			if(cityId!=null && (!cityId.equals(""))){
				city= entityManager.find(City.class, cityId);
			}
		}catch (Exception e) {
			logger.error("CityDaoImpl-getCityById-ERROR for cityId:"+cityId ,e);
		}
		logger.info("CityDaoImpl-getCityById-END for cityId:"+cityId);
		return city;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityDao#getCities()
	 */
	public List<City> getCities() {
		logger.info("CityDaoImpl-getCities-START");
		List<City> cities =null;
		try{
		CriteriaQuery<City> criteria = entityManager.getCriteriaBuilder().createQuery(City.class);
	    criteria.select(criteria.from(City.class));
	    cities = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("CityDaoImpl-getCities-ERROR",e);
		}
		logger.info("CityDaoImpl-getCities-END");
	    return cities;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityDao#saveCity(com.cityseller.repository.domain.City)
	 */
	public Boolean saveCity(City city) {
		logger.info("CityDaoImpl-saveCity-START");
		Boolean isSave=false;
		try{
			if(city != null){
				logger.info("CityDaoImpl-saveCity-saving city for: "+city.toString());
				entityManager.persist(city);  //saves the state object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("CityDaoImpl-saveCity-state object is null");
			}
		}catch(Exception e){
			logger.error("CityDaoImpl-saveCity-ERROR",e);
		}
		logger.info("CityDaoImpl-saveCity-END ");
		return isSave;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityDao#updateCity(com.cityseller.repository.domain.City)
	 */
	public Boolean updateCity(City city) {
		logger.info("CityDaoImpl-updateCity-START");
		Boolean isUpdated=false;
		try{
			if(city != null){
				logger.info("CityDaoImpl-updateCity-updating city for: "+city.getCityName());
				entityManager.merge(city);  //saves the userDetails object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("CityDaoImpl-updateCity-state city is null");
			}
		}catch(Exception e){
			logger.error("CityDaoImpl-updateCity-ERROR",e);
		}
		logger.info("CityDaoImpl-updateCity-END ");
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityDao#deleteCity(com.cityseller.repository.domain.City)
	 */
	public Boolean deleteCity(City city) {
		logger.info("CityDaoImpl-deleteCity-START");
		Boolean isDeleted=false;
		try{
			if(city != null){
				city=getCityById(city.getCityId());
				logger.info("CityDaoImpl-deleteState-deleteCity city  for: "+city.getCityName());
				entityManager.getLockMode(city);
				entityManager.remove(city);  //saves the Vendor object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("CityDaoImpl-deleteCity-country  object is null");
			} 
		}catch(Exception e){
			logger.error("CityDaoImpl-deleteCity-ERROR",e);
		}
		logger.info("CityDaoImpl-deleteCity-END ");
		return isDeleted;
	}

}

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

import com.cityseller.repository.dao.CityAreaDao;
import com.cityseller.repository.domain.CityArea;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class CityAreaDaoImpl implements CityAreaDao {

	private final static Logger logger = LoggerFactory.getLogger(CityAreaDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityAreaDao#getCityAreaById(java.lang.Long)
	 */
	@Override
	public CityArea getCityAreaById(Long cityAreaId) {
		logger.info("CityAreaDaoImpl-getCityAreaById-START for cityAreaId:"+cityAreaId);
		CityArea cityArea=null;
		try{
			if(cityAreaId!=null && (!cityAreaId.equals(""))){
				cityArea= entityManager.find(CityArea.class, cityAreaId);
			}
		}catch (Exception e) {
			logger.error("CityAreaDaoImpl-getCityAreaById-ERROR for cityAreaId:"+cityAreaId ,e);
		}
		logger.info("CityAreaDaoImpl-getCityAreaById-END for cityAreaId:"+cityAreaId);
		return cityArea;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityAreaDao#getCityAreas()
	 */
	@Override
	public List<CityArea> getCityAreas() {
		logger.info("CityAreaDaoImpl-getCityAreas-START");
		List<CityArea> cityAreas =null;
		try{
		CriteriaQuery<CityArea> criteria = entityManager.getCriteriaBuilder().createQuery(CityArea.class);
	    criteria.select(criteria.from(CityArea.class));
	    cityAreas = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("CityAreaDaoImpl-getCityAreas-ERROR",e);
		}
		logger.info("CityAreaDaoImpl-getCityAreas-END");
	    return cityAreas;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityAreaDao#saveCityArea(com.cityseller.repository.domain.CityArea)
	 */
	@Override
	public Boolean saveCityArea(CityArea cityArea) {
		logger.info("CityAreaDaoImpl-saveCityArea-START");
		Boolean isSave=false;
		try{
			if(cityArea != null){
				logger.info("CityAreaDaoImpl-saveCityArea-saving cityArea for: "+cityArea.toString());
				entityManager.persist(cityArea);  //saves the state object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("CityAreaDaoImpl-saveCityArea-cityArea object is null");
			}
		}catch(Exception e){
			logger.error("CityAreaDaoImpl-saveCityArea-ERROR",e);
		}
		logger.info("CityAreaDaoImpl-saveCityArea-END ");
		return isSave;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityAreaDao#updateCityArea(com.cityseller.repository.domain.CityArea)
	 */
	@Override
	public Boolean updateCityArea(CityArea cityArea) {
		logger.info("CityAreaDaoImpl-updateCityArea-START");
		Boolean isUpdated=false;
		try{
			if(cityArea != null){
				logger.info("CityAreaDaoImpl-updateCityArea-updating cityArea for: "+cityArea.getAreaName());
				entityManager.merge(cityArea);  //update the cityArea object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("CityAreaDaoImpl-updateCityArea-state city is null");
			}
		}catch(Exception e){
			logger.error("CityAreaDaoImpl-updateCityArea-ERROR",e);
		}
		logger.info("CityAreaDaoImpl-updateCityArea-END ");
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.CityAreaDao#deleteCityArea(com.cityseller.repository.domain.CityArea)
	 */
	@Override
	public Boolean deleteCityArea(CityArea cityArea) {
		logger.info("CityAreaDaoImpl-deleteCityArea-START");
		Boolean isDeleted=false;
		try{
			if(cityArea != null){
				cityArea=getCityAreaById(cityArea.getCityAreaId());
				logger.info("CityAreaDaoImpl-deleteCityArea-cityArea for: "+cityArea.getAreaName());
				entityManager.getLockMode(cityArea);
				entityManager.remove(cityArea);  //saves the Vendor object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("CityAreaDaoImpl-deleteCityArea-cityArea  object is null");
			} 
		}catch(Exception e){
			logger.error("CityAreaDaoImpl-deleteCityArea-ERROR",e);
		}
		logger.info("CityAreaDaoImpl-deleteCityArea-END ");
		return isDeleted;
	}

}

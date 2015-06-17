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

import com.cityseller.repository.dao.FeatureDao;
import com.cityseller.repository.domain.Features;

/**
 * @author jeetendra.patidar
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class FeatureDaoImpl implements FeatureDao {
	
	private final static Logger logger = LoggerFactory.getLogger(FeatureDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	public Features getFeatureById(Long featureId) {
		logger.info("FeatureDaoImpl-getFeatureById-START for featureId:"+featureId);
		Features features=null;
		try{
			if(featureId!=null && (!featureId.equals(""))){
				features= entityManager.find(Features.class, featureId);
			}
		}catch (Exception e) {
			logger.error("FeatureDaoImpl-getFeatureById-ERRO for featureId:"+featureId ,e);
		}
		logger.info("FeatureDaoImpl-getFeatureById-END for featureId:"+featureId);
		return features;
	}

	public List<Features> getAllFeatures() {
		logger.info("FeatureDaoImpl-getAllFeatures-START");
		List<Features> listOfFeatures =null;
		try{
		CriteriaQuery<Features> criteria = entityManager.getCriteriaBuilder().createQuery(Features.class);
	    criteria.select(criteria.from(Features.class));
	    listOfFeatures = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("FeatureDaoImpl-getAllFeatures-ERROR",e);
		}
		logger.info("FeatureDaoImpl-getAllFeatures-END");
	    return listOfFeatures;
	}
    @Transactional
	public Boolean saveFeature(Features features) {
		logger.info("FeatureDaoImpl-saveFeature-START");
		Boolean isSave=false;
		try{
			if(features != null){
				logger.info("FeatureDaoImpl-saveFeature-saving features for: "+features.toString());
				entityManager.persist(features);  //saves the features object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("FeatureDaoImpl-saveFeature-features object is null");
			}
		}catch(Exception e){
			logger.error("FeatureDaoImpl-saveFeature-ERROR",e);
		}
		logger.info("FeatureDaoImpl-saveFeature-END ");
		return isSave;
	}

	public Boolean updateFeature(Features features) {
		logger.info("FeatureDaoImpl-features-START");
		Boolean isUpdated=false;
		try{
			if(features != null){
				logger.info("FeatureDaoImpl-updateProduct-updating product  for: "+features.toString());
				entityManager.merge(features);  //saves the features object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("FeatureDaoImpl-updateProduct-features object is null");
			}
		}catch(Exception e){
			logger.error("FeatureDaoImpl-updateProduct-ERROR",e);
		}
		logger.info("FeatureDaoImpl-updateCategory-END ");
		return isUpdated;
	}

	public Boolean deleteFeature(Features features) {
		logger.info("FeatureDaoImpl-deleteFeature-START");
		Boolean isDeleted=false;
		try{
			if(features != null){
				features=getFeatureById(features.getFeatureId());
				logger.info("FeatureDaoImpl-deleteFeature-deleteing features  for: "+features.toString());
				entityManager.getLockMode(features);
				entityManager.remove(features);  //delete the features object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("FeatureDaoImpl-deleteFeature-features object is null");
			} 
		}catch(Exception e){
			logger.error("FeatureDaoImpl-deleteFeature-ERROR",e);
		}
		logger.info("FeatureDaoImpl-deleteFeature-END ");
		return isDeleted;
	}
}

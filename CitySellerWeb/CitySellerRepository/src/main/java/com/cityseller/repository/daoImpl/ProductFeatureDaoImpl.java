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

import com.cityseller.repository.dao.ProductFeatureDao;
import com.cityseller.repository.domain.ProductFeature;

/**
 * @author jeetendra.patidar
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class ProductFeatureDaoImpl implements ProductFeatureDao {
	
	private final static Logger logger = LoggerFactory.getLogger(ProductFeatureDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	public ProductFeature getProductFeatureById(Long productFeatureId) {
		logger.info("ProductFeatureDaoImpl-getProductFeatureById-START for productFeatureId:"+productFeatureId);
		ProductFeature productFeature=null;
		try{
			if(productFeatureId!=null && (!productFeatureId.equals(""))){
				productFeature= entityManager.find(ProductFeature.class, productFeatureId);
			}
		}catch (Exception e) {
			logger.error("ProductFeatureDaoImpl-getProductFeatureById-ERRO for productFeatureId:"+productFeatureId ,e);
		}
		logger.info("ProductFeatureDaoImpl-getProductFeatureById-END for productFeatureId:"+productFeatureId);
		return productFeature;
	}

	public List<ProductFeature> getAllProductFeatures() {
		logger.info("ProductFeatureDaoImpl-getAllProductFeatures-START");
		List<ProductFeature> listOfProductFeature =null;
		try{
		CriteriaQuery<ProductFeature> criteria = entityManager.getCriteriaBuilder().createQuery(ProductFeature.class);
	    criteria.select(criteria.from(ProductFeature.class));
	    listOfProductFeature = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("ProductFeatureDaoImpl-getAllProductFeatures-ERROR",e);
		}
		logger.info("ProductFeatureDaoImpl-getAllProductFeatures-END");
	    return listOfProductFeature;
	}
    @Transactional
	public Boolean saveProductFeature(ProductFeature productFeature) {
		logger.info("ProductFeatureDaoImpl-saveProductFeature-START");
		Boolean isSave=false;
		try{
			if(productFeature != null){
				logger.info("ProductFeatureDaoImpl-saveProductFeature-saving productFeature for: "+productFeature.toString());
				entityManager.persist(productFeature);  //saves the productFeature object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("ProductFeatureDaoImpl-saveProductFeature-productFeature object is null");
			}
		}catch(Exception e){
			logger.error("ProductFeatureDaoImpl-saveProductFeature-ERROR",e);
		}
		logger.info("ProductFeatureDaoImpl-saveProductFeature-END ");
		return isSave;
	}

	public Boolean updateProductFeature(ProductFeature productFeature) {
		logger.info("ProductFeatureDaoImpl-updateProductFeuture-START");
		Boolean isUpdated=false;
		try{
			if(productFeature != null){
				logger.info("ProductFeatureDaoImpl-updateProductFeuture-updating product  for: "+productFeature.toString());
				entityManager.merge(productFeature);  //saves the product object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("ProductFeatureDaoImpl-updateProductFeuture-product object is null");
			}
		}catch(Exception e){
			logger.error("ProductFeatureDaoImpl-updateProductFeuture-ERROR",e);
		}
		logger.info("ProductFeatureDaoImpl-updateProductFeuture-END ");
		return isUpdated;
	}

	public Boolean deleteProductFeature(ProductFeature productFeature) {
		logger.info("ProductFeatureDaoImpl-deleteProductFeature-START");
		Boolean isDeleted=false;
		try{
			if(productFeature != null){
				productFeature=getProductFeatureById(productFeature.getId());
				logger.info("ProductFeatureDaoImpl-deleteProductFeature-deleteing productFeature detail for: "+productFeature.toString());
				entityManager.getLockMode(productFeature);
				entityManager.remove(productFeature);  //delete the productFeature object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("ProductFeatureDaoImpl-deleteProductFeature-productFeature object is null");
			} 
		}catch(Exception e){
			logger.error("ProductFeatureDaoImpl-deleteProductFeature-ERROR",e);
		}
		logger.info("ProductFeatureDaoImpl-deleteProductFeature-END ");
		return isDeleted;
	}

}

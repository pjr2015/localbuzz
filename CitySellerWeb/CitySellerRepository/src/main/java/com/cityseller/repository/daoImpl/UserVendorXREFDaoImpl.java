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

import com.cityseller.repository.dao.UserVendorXREFDao;
import com.cityseller.repository.domain.UserVendorXREF;
import com.cityseller.repository.domain.Vendor;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class UserVendorXREFDaoImpl implements UserVendorXREFDao {

	
private final static Logger logger = LoggerFactory.getLogger(UserVendorXREFDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;
	
	
	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.UserVendorXREFDao#getUserVendorXREFbyId(java.lang.Long)
	 */
	public UserVendorXREF getUserVendorXREFbyId(Long xrefId) {
		logger.info("UserVendorXREFDaoImpl-getUserVendorXREFbyId-START for xrefId:"+xrefId);
		UserVendorXREF userVendorXREF=null;
		try{
			if(xrefId!=null && (!xrefId.equals(""))){
				userVendorXREF= entityManager.find(UserVendorXREF.class, xrefId);
			}
		}catch (Exception e) {
			logger.error("UserVendorXREFDaoImpl-getUserVendorXREFbyId-ERROR for xrefId:"+xrefId ,e);
		}
		logger.info("UserVendorXREFDaoImpl-getUserVendorXREFbyId-END for xrefId:"+xrefId);
		return userVendorXREF;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.UserVendorXREFDao#getUserVendorXREFs()
	 */
	public List<UserVendorXREF> getUserVendorXREFs() {
		logger.info("UserVendorXREFDaoImpl-getUserVendorXREFbyId-START");
		List<UserVendorXREF> vendorXREFs =null;
		try{
		CriteriaQuery<UserVendorXREF> criteria = entityManager.getCriteriaBuilder().createQuery(UserVendorXREF.class);
	    criteria.select(criteria.from(UserVendorXREF.class));
	    vendorXREFs = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("UserVendorXREFDaoImpl-getUserVendorXREFbyId-ERROR",e);
		}
		logger.info("UserVendorXREFDaoImpl-getUserVendorXREFbyId-END");
	    return vendorXREFs;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.UserVendorXREFDao#saveUserVendorXREF(com.cityseller.repository.domain.UserVendorXREF)
	 */
	public Boolean saveUserVendorXREF(UserVendorXREF userVendorXREF) {
		logger.info("UserVendorXREFDaoImpl-saveUserVendorXREF-START");
		Boolean isSave=false;
		try{
			if(userVendorXREF != null){
				logger.info("UserVendorXREFDaoImpl-saveUserVendorXREF-saving userVendorXREF");
				entityManager.persist(userVendorXREF);  //saves the userDetails object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("UserVendorXREFDaoImpl-saveUserVendorXREF-userVendorXREF  object is null");
			}
		}catch(Exception e){
			logger.error("UserVendorXREFDaoImpl-saveUserVendorXREF-ERROR",e);
		}
		logger.info("UserVendorXREFDaoImpl-saveUserVendorXREF-END ");
		return isSave;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.UserVendorXREFDao#updateUserVendorXREF(com.cityseller.repository.domain.UserVendorXREF)
	 */
	public Boolean updateUserVendorXREF(UserVendorXREF userVendorXREF) {
		logger.info("UserVendorXREFDaoImpl-updateUserVendorXREF-START");
		Boolean isUpdated=false;
		try{
			if(userVendorXREF != null){
				logger.info("UserVendorXREFDaoImpl-updateUserVendorXREF-updating userVendorXREF for id: "+userVendorXREF.getId());
				entityManager.merge(userVendorXREF);  //saves the UserVendorXREFDaoImpl object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("UserVendorXREFDaoImpl-updateUserVendorXREF-userVendorXREF object is null");
			}
		}catch(Exception e){
			logger.error("UserVendorXREFDaoImpl-updateUserVendorXREF-ERROR",e);
		}
		logger.info("UserVendorXREFDaoImpl-updateUserVendorXREF-END ");
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.UserVendorXREFDao#deleteUserVendorXREF(com.cityseller.repository.domain.UserVendorXREF)
	 */
	public Boolean deleteUserVendorXREF(UserVendorXREF userVendorXREF) {
		logger.info("UserVendorXREFDaoImpl-deleteUserVendorXREF-START");
		Boolean isDeleted=false;
		try{
			if(userVendorXREF != null){
				userVendorXREF=getUserVendorXREFbyId(userVendorXREF.getId());
				logger.info("UserVendorXREFDaoImpl-deleteUserVendorXREF-deleteing userVendorXREF for: "+userVendorXREF.toString());
				entityManager.getLockMode(userVendorXREF);
				entityManager.remove(userVendorXREF);  //saves the Vendor object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("UserVendorXREFDaoImpl-deleteUserVendorXREF-userVendorXREF  object is null");
			} 
		}catch(Exception e){
			logger.error("UserVendorXREFDaoImpl-deleteUserVendorXREF-ERROR",e);
		}
		logger.info("UserVendorXREFDaoImpl-deleteUserVendorXREF-END ");
		return isDeleted;
	}

}

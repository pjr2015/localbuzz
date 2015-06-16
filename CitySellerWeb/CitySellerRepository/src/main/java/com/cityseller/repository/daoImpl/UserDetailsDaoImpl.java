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

import com.cityseller.repository.dao.UserDetailsDao;
import com.cityseller.repository.domain.UserDetails;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class UserDetailsDaoImpl implements UserDetailsDao {
	
	private final static Logger logger = LoggerFactory.getLogger(UserDetailsDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	public UserDetails getUserDetailsById(Long userId) {
		logger.info("UserDetailsDaoImpl-getUserDetailsById-START for userId:"+userId);
		UserDetails userDetails=null;
		try{
			if(userId!=null && (!userId.equals(""))){
				userDetails= entityManager.find(UserDetails.class, userId);
			}
		}catch (Exception e) {
			logger.error("UserDetailsDaoImpl-getUserDetailsById-ERRO for userId:"+userId ,e);
		}
		logger.info("UserDetailsDaoImpl-getUserDetailsById-END for userId:"+userId);
		return userDetails;
	}

	public List<UserDetails> getUserDetails() {
		logger.info("UserDetailsDaoImpl-getUserDetails-START");
		List<UserDetails> ListOfUserDetails =null;
		try{
		CriteriaQuery<UserDetails> criteria = entityManager.getCriteriaBuilder().createQuery(UserDetails.class);
	    criteria.select(criteria.from(UserDetails.class));
	     ListOfUserDetails = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("UserDetailsDaoImpl-getUserDetails-ERROR",e);
		}
		logger.info("UserDetailsDaoImpl-getUserDetails-END");
	    return ListOfUserDetails;
	}
    @Transactional
	public Boolean saveUserDetails(UserDetails userDetails) {
		logger.info("UserDetailsDaoImpl-saveUserDetails-START");
		Boolean isSave=false;
		try{
			if(userDetails != null){
				logger.info("UserDetailsDaoImpl-saveUserDetails-saving user detail for: "+userDetails.toString());
				entityManager.persist(userDetails);  //saves the userDetails object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("UserDetailsDaoImpl-saveUserDetails-user details object is null");
			}
		}catch(Exception e){
			logger.error("UserDetailsDaoImpl-saveUserDetails-ERROR",e);
		}
		logger.info("UserDetailsDaoImpl-saveUserDetails-END ");
		return isSave;
	}

	public Boolean updateUserDetails(UserDetails userDetails) {
		logger.info("UserDetailsDaoImpl-saveUserDetails-START");
		Boolean isUpdated=false;
		try{
			if(userDetails != null){
				logger.info("UserDetailsDaoImpl-updateUserDetails-updating user detail for: "+userDetails.toString());
				entityManager.merge(userDetails);  //saves the userDetails object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("UserDetailsDaoImpl-updateUserDetails-user details object is null");
			}
		}catch(Exception e){
			logger.error("UserDetailsDaoImpl-saveUserDetails-ERROR",e);
		}
		logger.info("UserDetailsDaoImpl-saveUserDetails-END ");
		return isUpdated;
	}

	public Boolean deleteUserDetails(UserDetails userDetails) {
		logger.info("UserDetailsDaoImpl-deleteUserDetails-START");
		Boolean isDeleted=false;
		try{
			if(userDetails != null){
				userDetails=getUserDetailsById(userDetails.getUserId());
				logger.info("UserDetailsDaoImpl-deleteUserDetails-deleteing user detail for: "+userDetails.toString());
				entityManager.getLockMode(userDetails);
				entityManager.remove(userDetails);  //saves the userDetails object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("UserDetailsDaoImpl-deleteUserDetails-user details object is null");
			} 
		}catch(Exception e){
			logger.error("UserDetailsDaoImpl-deleteUserDetails-ERROR",e);
		}
		logger.info("UserDetailsDaoImpl-deleteUserDetails-END ");
		return isDeleted;
	}
}

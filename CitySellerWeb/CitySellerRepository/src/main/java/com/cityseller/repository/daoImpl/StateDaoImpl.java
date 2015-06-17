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

import com.cityseller.repository.dao.StateDao;
import com.cityseller.repository.domain.State;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class StateDaoImpl implements StateDao {
	
private final static Logger logger = LoggerFactory.getLogger(StateDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.StateDao#getStateById(java.lang.Long)
	 */
	public State getStateById(Long stateId) {
		logger.info("StateDaoImpl-getStateById-START for stateId:"+stateId);
		State state=null;
		try{
			if(stateId!=null && (!stateId.equals(""))){
				state= entityManager.find(State.class, stateId);
			}
		}catch (Exception e) {
			logger.error("StateDaoImpl-getStateById-ERROR for stateId:"+stateId ,e);
		}
		logger.info("StateDaoImpl-getStateById-END for stateId:"+stateId);
		return state;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.StateDao#getCountries()
	 */
	public List<State> getCountries() {
		logger.info("StateDaoImpl-getCountries-START");
		List<State> states =null;
		try{
		CriteriaQuery<State> criteria = entityManager.getCriteriaBuilder().createQuery(State.class);
	    criteria.select(criteria.from(State.class));
	    states = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("StateDaoImpl-getCountries-ERROR",e);
		}
		logger.info("StateDaoImpl-getCountries-END");
	    return states;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.StateDao#saveState(com.cityseller.repository.domain.State)
	 */
	public Boolean saveState(State state) {
		logger.info("StateDaoImpl-saveState-START");
		Boolean isSave=false;
		try{
			if(state != null){
				logger.info("StateDaoImpl-saveState-saving state  for: "+state.toString());
				entityManager.persist(state);  //saves the state object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("StateDaoImpl-saveState-state object is null");
			}
		}catch(Exception e){
			logger.error("StateDaoImpl-saveState-ERROR",e);
		}
		logger.info("StateDaoImpl-saveState-END ");
		return isSave;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.StateDao#updateState(com.cityseller.repository.domain.State)
	 */
	public Boolean updateState(State state) {
		logger.info("StateDaoImpl-updateState-START");
		Boolean isUpdated=false;
		try{
			if(state != null){
				logger.info("StateDaoImpl-updateState-updating state for: "+state.getStateName());
				entityManager.merge(state);  //saves the userDetails object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("StateDaoImpl-updateState-state country is null");
			}
		}catch(Exception e){
			logger.error("StateDaoImpl-updateState-ERROR",e);
		}
		logger.info("StateDaoImpl-updateState-END ");
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.StateDao#deleteState(com.cityseller.repository.domain.State)
	 */
	public Boolean deleteState(State state) {
		logger.info("StateDaoImpl-deleteState-START");
		Boolean isDeleted=false;
		try{
			if(state != null){
				state=getStateById(state.getStateId());
				logger.info("StateDaoImpl-deleteState-delete State  for: "+state.getStateName());
				entityManager.getLockMode(state);
				entityManager.remove(state);  //saves the Vendor object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("StateDaoImpl-deleteState-country  object is null");
			} 
		}catch(Exception e){
			logger.error("StateDaoImpl-deleteState-ERROR",e);
		}
		logger.info("StateDaoImpl-deleteState-END ");
		return isDeleted;
	}

}

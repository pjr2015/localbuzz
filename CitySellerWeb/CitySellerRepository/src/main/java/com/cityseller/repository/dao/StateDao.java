/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.State;

/**
 * @author pavan.gupta
 *
 */
public interface StateDao {

	public State getStateById(Long stateId);
	
	public List<State> getCountries(); 
	
	public Boolean saveState(State state);
	
	public Boolean updateState(State state);
	
	public Boolean deleteState(State state);
}

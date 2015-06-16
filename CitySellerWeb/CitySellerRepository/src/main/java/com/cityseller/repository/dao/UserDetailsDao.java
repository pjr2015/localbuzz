/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;

import com.cityseller.repository.domain.UserDetails;

/**
 * @author pavan.gupta
 *
 */
public interface UserDetailsDao {

	public UserDetails getUserDetailsById(Long userId);
	
	public List<UserDetails> getUserDetails(); 
	
	public Boolean saveUserDetails(UserDetails userDetails);
	
	public Boolean updateUserDetails(UserDetails userDetails);
	
	public Boolean deleteUserDetails(UserDetails userDetails);
}

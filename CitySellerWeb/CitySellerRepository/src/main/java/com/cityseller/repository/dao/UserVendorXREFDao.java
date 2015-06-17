/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;
import com.cityseller.repository.domain.UserVendorXREF;


/**
 * @author pavan.gupta
 *
 */
public interface UserVendorXREFDao {

	public UserVendorXREF getUserVendorXREFbyId(Long xrefId);
	
	public List<UserVendorXREF> getUserVendorXREFs(); 
	
	public Boolean saveUserVendorXREF(UserVendorXREF userVendorXREF);
	
	public Boolean updateUserVendorXREF(UserVendorXREF userVendorXREF);
	
	public Boolean deleteUserVendorXREF(UserVendorXREF userVendorXREF);
}

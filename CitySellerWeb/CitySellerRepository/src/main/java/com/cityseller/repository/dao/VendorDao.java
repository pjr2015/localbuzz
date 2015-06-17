/**
 * 
 */
package com.cityseller.repository.dao;

import java.util.List;
import com.cityseller.repository.domain.Vendor;

/**
 * @author pavan.gupta
 *
 */
public interface VendorDao {
	
	public Vendor getVendorById(Long vendorId);
	
	public List<Vendor> getVendors(); 
	
	public Boolean saveVendor(Vendor vendor);
	
	public Boolean updateVendor(Vendor vendor);
	
	public Boolean deleteVendor(Vendor vendor);

}

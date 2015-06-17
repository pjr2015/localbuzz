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
import com.cityseller.repository.dao.VendorDao;
import com.cityseller.repository.domain.Vendor;

/**
 * @author pavan.gupta
 *
 */
@Component
@Transactional(rollbackFor = PersistenceException.class)
public class VendorDaoImpl implements VendorDao {

	private final static Logger logger = LoggerFactory.getLogger(VendorDaoImpl.class);
	
	@PersistenceContext(unitName = "JpaPersistenceUnit")
    private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.VendorDao#getVendorById(java.lang.Long)
	 */
	public Vendor getVendorById(Long vendorId) {
		logger.info("VendorDaoImpl-getVendorById-START for vendorId:"+vendorId);
		Vendor vendor=null;
		try{
			if(vendorId!=null && (!vendorId.equals(""))){
				vendor= entityManager.find(Vendor.class, vendorId);
			}
		}catch (Exception e) {
			logger.error("VendorDaoImpl-getVendorById-ERROR for vendorId:"+vendorId ,e);
		}
		logger.info("VendorDaoImpl-getVendorById-END for vendorId:"+vendorId);
		return vendor;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.VendorDao#getVendors()
	 */
	public List<Vendor> getVendors() {
		logger.info("VendorDaoImpl-getVendors-START");
		List<Vendor> vendors =null;
		try{
		CriteriaQuery<Vendor> criteria = entityManager.getCriteriaBuilder().createQuery(Vendor.class);
	    criteria.select(criteria.from(Vendor.class));
	    vendors = entityManager.createQuery(criteria).getResultList();
		}catch(Exception e){
			logger.error("VendorDaoImpl-getVendors-ERROR",e);
		}
		logger.info("VendorDaoImpl-getVendors-END");
	    return vendors;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.VendorDao#saveVendor(com.cityseller.repository.domain.Vendor)
	 */
	public Boolean saveVendor(Vendor vendor) {
		logger.info("VendorDaoImpl-saveVendor-START");
		Boolean isSave=false;
		try{
			if(vendor != null){
				logger.info("VendorDaoImpl-saveVendor-saving vendor  for: "+vendor.toString());
				entityManager.persist(vendor);  //saves the vendor object
				entityManager.flush();
				isSave=true;
			} else{
				logger.info("VendorDaoImpl-saveVendor-vendor  object is null");
			}
		}catch(Exception e){
			logger.error("VendorDaoImpl-saveVendor-ERROR",e);
		}
		logger.info("VendorDaoImpl-saveVendor-END ");
		return isSave;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.VendorDao#updateVendor(com.cityseller.repository.domain.Vendor)
	 */
	public Boolean updateVendor(Vendor vendor) {
		logger.info("VendorDaoImpl-updateVendor-START");
		Boolean isUpdated=false;
		try{
			if(vendor != null){
				logger.info("VendorDaoImpl-updateVendor-updating vendor for: "+vendor.toString());
				entityManager.merge(vendor);  //saves the userDetails object
				entityManager.flush();
				isUpdated=true;
			} else{
				logger.info("VendorDaoImpl-updateVendor-vendor object is null");
			}
		}catch(Exception e){
			logger.error("VendorDaoImpl-updateVendor-ERROR",e);
		}
		logger.info("VendorDaoImpl-updateVendor-END ");
		return isUpdated;
	}

	/* (non-Javadoc)
	 * @see com.cityseller.repository.dao.VendorDao#deleteVendor(com.cityseller.repository.domain.Vendor)
	 */
	public Boolean deleteVendor(Vendor vendor) {
		logger.info("UserDetailsDaoImpl-deleteVendor-START");
		Boolean isDeleted=false;
		try{
			if(vendor != null){
				vendor=getVendorById(vendor.getVendorId());
				logger.info("UserDetailsDaoImpl-deleteVendor-deleteing vendor for: "+vendor.toString());
				entityManager.getLockMode(vendor);
				entityManager.remove(vendor);  //saves the Vendor object
				entityManager.flush();
				isDeleted=true;
			}else{
				logger.info("UserDetailsDaoImpl-deleteVendor-vendor  object is null");
			} 
		}catch(Exception e){
			logger.error("UserDetailsDaoImpl-deleteVendor-ERROR",e);
		}
		logger.info("UserDetailsDaoImpl-deleteVendor-END ");
		return isDeleted;
	}

}

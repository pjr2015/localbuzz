/**
 * 
 */
package com.cityseller.repository.configuration;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

import com.cityseller.repository.dao.CityDao;
import com.cityseller.repository.dao.CountryDao;
import com.cityseller.repository.dao.StateDao;
import com.cityseller.repository.dao.UserDetailsDao;
import com.cityseller.repository.dao.UserVendorXREFDao;
import com.cityseller.repository.dao.VendorDao;
import com.cityseller.repository.domain.City;
import com.cityseller.repository.domain.Country;
import com.cityseller.repository.domain.Role;
import com.cityseller.repository.domain.State;
import com.cityseller.repository.domain.UserDetails;
import com.cityseller.repository.domain.UserVendorXREF;
import com.cityseller.repository.domain.Vendor;

/**
 * @author pavan.gupta
 *
 */
@Configuration
@ComponentScan(basePackages="org.SubHelloWorld")
@EnableAutoConfiguration()
@EnableAsync
//@PropertySource({"${app.config}"})
@ImportResource({"classpath*:applicationContext.xml"})
public class CitySellerRepositoryConfiguration {

	
	@Autowired
	private UserDetailsDao userDetailsDAO;
	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private UserVendorXREFDao userVendorDAO;
	
	@Autowired
	private CountryDao counrtyDao;
	
	@Autowired
	private StateDao stateDao;
	
	@Autowired
	private CityDao cityDao;
	
	@PostConstruct
	 public void test(){
		//testUserDetails();
		
		//testVendor();
		
		//testUserVendorXREF();
		//testCountry();
		//testState();
		testCity();
	 }
	
	
	public void testCity(){
		
		UserDetails userDetails= saveUserDetails();
		//userDetailsDAO.saveUserDetails(userDetails);
	saveCity();
		
		
	/*	UserDetails userDetails= uodateUserDetails();
		userDetailsDAO.updateUserDetails(userDetails);*/
		
	/*	UserDetails userDetails= deleteUserDetails();
		userDetailsDAO.deleteUserDetails(dm);*/
		
		List<UserDetails> list= userDetailsDAO.getUserDetails();
		System.out.println(list.size());
	 }
	
	public UserDetails  saveUserDetails(){
		UserDetails userDetails=new UserDetails();
		userDetails.setfName("jeetu");
		userDetails.setlName("patidar");
		userDetails.setLoginName("jeetu.jeetu");
		userDetails.setPassword("password");
		Role roleDm=new Role();
		roleDm.setRoleId(new Long(2));
		//roleDm.setRole("Admin");
		userDetails.setRoleDm(roleDm);
		//userDetails.setUserId(3L);
		return userDetails;
		
	}
	
	public UserDetails  uodateUserDetails(){
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(new Long(2));
		userDetails.setfName("jeetu1");
		userDetails.setlName("patidar");
		userDetails.setLoginName("jeetu.jeetu");
		userDetails.setPassword("password");
		Role roleDm=new Role();
		roleDm.setRoleId(new Long(2));
		//roleDm.setRole("Admin");
		userDetails.setRoleDm(roleDm);
		//userDetails.setUserId(3L);
		return userDetails;
		
	}
	
	public UserDetails  deleteUserDetails(){
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(new Long(3));
		return userDetails;
		
	}
	public Vendor  deleteVendor(){
		Vendor vendor=new Vendor();
		vendor.setVendorId(new Long(7));
		return vendor;
		
	}
	
	public UserVendorXREF updateUserVendorXREF(){
		UserVendorXREF userVendorXREF=userVendorDAO.getUserVendorXREFbyId(new Long(2));
		UserDetails userDetails= userDetailsDAO.getUserDetailsById(new Long(2));
		Vendor vendor= vendorDao.getVendorById(new Long(18));
		
		userVendorXREF.setUserDetails(userDetails);
		userVendorXREF.setVendor(vendor);
		return userVendorXREF ;
	}
	
	public UserVendorXREF deleteUserVendorXREF(){
		UserVendorXREF userVendorXREF=userVendorDAO.getUserVendorXREFbyId(new Long(2));
		return userVendorXREF ;
	}
		public Vendor  updateVendor(){
		Vendor vendor=new Vendor();
		vendor.setContactNumber(new Integer(123456789));
		vendor.setCreatedBy("test");
		vendor.setCreatedDate(new Date());
		vendor.setEmailId("qwe@qwe.com");
		vendor.setFirstName("asd");
		vendor.setLandlineNumber(new Integer("123123123"));
		vendor.setLastName("test");
		vendor.setMobileNumber(new Integer(12312));
		vendor.setModifiedBy("test");
		vendor.setModifiedBy("etwt");
		vendor.setModifiedDate(new Date());
		vendor.setRegistrationDate(new Date());
		vendor.setRegistrationNumber("sadasd");
		vendor.setShopName("asd");
		vendor.setVendorId(new Long(7));
		UserDetails userDetails=userDetailsDAO.getUserDetailsById(new Long(2));
		vendor.setUserDetails(userDetails);
		return vendor;
		
	}
		public Vendor  saveVendor(){
		Vendor vendor=new Vendor();
		vendor.setContactNumber(new Integer(123456789));
		vendor.setCreatedBy("test");
		vendor.setCreatedDate(new Date());
		vendor.setEmailId("qwe@qwe.com");
		vendor.setFirstName("qwe");
		vendor.setLandlineNumber(new Integer("123123123"));
		vendor.setLastName("test");
		vendor.setMobileNumber(new Integer(12312));
		vendor.setModifiedBy("test");
		vendor.setModifiedBy("etwt");
		vendor.setModifiedDate(new Date());
		vendor.setRegistrationDate(new Date());
		vendor.setRegistrationNumber("sadasd");
		vendor.setShopName("asd");
		
		UserDetails userDetails=userDetailsDAO.getUserDetailsById(new Long(2));
		vendor.setUserDetails(userDetails);
		return vendor;
		
	}
		public void saveCity(){
		
		City city=new City();
		city.setCityName("Indore");
	//	stateDao.getStateById(stateId)
	}
	
	public void testState(){
		
		//saveState();
	//	updateState();
		deleteState();
	}
	
	public void saveState(){
		State state=new State();
		Country country=counrtyDao.getCountryById(new Long(2));
		state.setCountry(country);
		state.setStateName("MP");
		stateDao.saveState(state);
		
	}
	
	public void updateState(){
		State state=stateDao.getStateById(new Long(1));
		state.setStateName("AP");
		stateDao.updateState(state);
		
	}
	public void deleteState(){
		State state=stateDao.getStateById(new Long(1));
		stateDao.deleteState(state);
	}
	
	
	
	
	
	
	
	
	
	public void testCountry(){
		
		//saveCountry();
		getCountryById();
		//updateCountry();
		//deleteCountry();
	}
	
	public void getCountryById(){
		Country country=counrtyDao.getCountryById(new Long(1));
		System.out.println(country.toString());
	}
	
	public void updateCountry(){
		Country country=counrtyDao.getCountryById(new Long(1));
		country.setCountryCode("en_IN");
		counrtyDao.updateCountry(country);
	}
	
	public void deleteCountry(){
		Country country=counrtyDao.getCountryById(new Long(1));
		counrtyDao.deleteCountry(country);
	}
	
	public Country saveCountry(){
		Country country=new Country();
		country.setCountryName("India");
		country.setCountryCode("IN");
		counrtyDao.saveCountry(country);
		return country;
	}
	
	public UserVendorXREF saveVendorXref(){
		UserVendorXREF userVendorXREF=new UserVendorXREF();
		UserDetails userDetails= userDetailsDAO.getUserDetailsById(new Long(2));
		Vendor vendor= vendorDao.getVendorById(new Long(8));
		
		userVendorXREF.setUserDetails(userDetails);
		userVendorXREF.setVendor(vendor);
		return userVendorXREF ;
	}
	
public void testUserVendorXREF(){
		
		/*UserVendorXREF userVendorXREF=	saveVendorXref();
		userVendorDAO.saveUserVendorXREF(userVendorXREF);*/
		
		
		/*UserVendorXREF userVendorXREF=	updateUserVendorXREF();
		userVendorDAO.updateUserVendorXREF(userVendorXREF);*/
		
		UserVendorXREF userVendorXREF=deleteUserVendorXREF();
		userVendorDAO.deleteUserVendorXREF(userVendorXREF);
		
	}
	public void testVendor(){
		/*Vendor vendor=saveVendor();
		vendorDao.saveVendor(vendor);
		*/
		
		/*Vendor vendor=updateVendor();
		vendorDao.updateVendor(vendor);*/
		
		/*Vendor vendor=vendorDao.getVendorById(new Long(7));
		List<Vendor>vendors= vendorDao.getVendors();
		System.out.println("hi");
		
		Vendor vendor2=deleteVendor();
		vendorDao.deleteVendor(vendor2);*/
	}
	
	/*public void testUserDetails(){
		 Long id=new Long(4);
			UserDetails dm= userDetailsDAO.getUserDetailsById(id);
		//	System.out.println(dm.getfName());
			UserDetails userDetails= saveUserDetails();
			//userDetailsDAO.saveUserDetails(userDetails);
			
			
			UserDetails userDetails= uodateUserDetails();
			userDetailsDAO.updateUserDetails(userDetails);
			
			UserDetails userDetails= deleteUserDetails();
			userDetailsDAO.deleteUserDetails(dm);
			
			List<UserDetails> list= userDetailsDAO.getUserDetails();
			System.out.println(list.size());
	}*/
}

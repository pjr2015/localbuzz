/**
 * 
 */
package com.cityseller.repository.configuration;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

import com.cityseller.repository.dao.UserDetailsDao;
import com.cityseller.repository.domain.Role;
import com.cityseller.repository.domain.UserDetails;

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
	
	@PostConstruct
	 public void test(){
		 Long id=new Long(4);
		UserDetails dm= userDetailsDAO.getUserDetailsById(id);
	//	System.out.println(dm.getfName());
		
		UserDetails userDetails= saveUserDetails();
		//userDetailsDAO.saveUserDetails(userDetails);
		
		
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
}

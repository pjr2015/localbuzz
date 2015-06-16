/**
 * 
 */
package com.cityseller.repository.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author pavan.gupta
 *
 */
@Entity
@Table(name = "user_details")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", updatable = true, nullable = false, insertable = false)
	private Long userId;
	
	@Column(name = "LOGIN_NAME", updatable = true, insertable = true)
	private String loginName;
	
	@Column(name = "PASSWORD", updatable = true, insertable = true)
	private String password;
	
	@Column(name = "FIRST_NAME", updatable = true, insertable = true)
	private String fName;
	
	@Column(name = "LAST_NAME", updatable = true, insertable = true)
	private String lName;
	
	
	@Column(name = "SHOP_NAME", updatable = true, insertable = true)
	private String shopName;
	
	@OneToOne(cascade=CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinColumn(name="ROLE_ID")
	private Role roleDm;
	
	/**
	 * @return the roleDm
	 */
	public Role getRoleDm() {
		return roleDm;
	}
	/**
	 * @param roleDm the roleDm to set
	 */
	public void setRoleDm(Role roleDm) {
		this.roleDm = roleDm;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", loginName=" + loginName + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + ", shopName=" + shopName +  "]";
	}
}

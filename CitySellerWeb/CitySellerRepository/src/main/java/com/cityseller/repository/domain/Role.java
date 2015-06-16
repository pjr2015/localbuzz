/**
 * 
 */
package com.cityseller.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author pavan.gupta
 *
 */
@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "ROLE_ID", updatable = true, nullable = false, insertable = true)
	private Long roleId;
	
	@Column(name = "ROLE", updatable = true, insertable = true)
	private String role;

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}

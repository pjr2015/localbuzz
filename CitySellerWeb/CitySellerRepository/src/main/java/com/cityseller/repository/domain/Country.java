/**
 * 
 */
package com.cityseller.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pavan.gupta
 *
 */
@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@Column(name = "COUNTRY_ID", updatable = true, nullable = false, insertable = true)
	private Long countryId;
	
	@Column(name = "COUNTRY_NAME", updatable = true, insertable = true)
	private String countryName;
	
	@Column(name = "COUNTRY_CODE", updatable = true, insertable = true)
	private String countryCode;

	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}

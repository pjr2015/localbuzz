/**
 * 
 */
package com.cityseller.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jeetendra.patidar
 *
 */
@Entity
@Table(name = "FEATURES")
public class Features {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FEATURE_ID", updatable = true, nullable = false, insertable = false)
	private long featureId;
	
	
	@Column(name = "DESCRIPTION", updatable = true, nullable = false, insertable = true)
	private String description;


	/**
	 * @return the featureId
	 */
	public long getFeatureId() {
		return featureId;
	}


	/**
	 * @param featureId the featureId to set
	 */
	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	


}

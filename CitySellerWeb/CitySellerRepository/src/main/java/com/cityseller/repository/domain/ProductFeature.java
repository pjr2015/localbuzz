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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author jeetendra.patidar
 *
 */
@Entity
@Table(name = "PRODUCT_FEATURE")
public class ProductFeature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = true, nullable = false, insertable = false)
	private long Id;
	
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="PRODUCT_ID")
	private Product productDm;
	
	
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="FEATURE_ID")
	private Features featureDm;
	
	@Column(name = "FEATURE_VALUE", updatable = true, nullable = false, insertable = true)
	private String featureValue;

	/**
	 * @return the id
	 */
	public long getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		Id = id;
	}

	/**
	 * @return the productDm
	 */
	public Product getProductDm() {
		return productDm;
	}

	/**
	 * @param productDm the productDm to set
	 */
	public void setProductDm(Product productDm) {
		this.productDm = productDm;
	}

	/**
	 * @return the featureDm
	 */
	public Features getFeatureDm() {
		return featureDm;
	}

	/**
	 * @param featureDm the featureDm to set
	 */
	public void setFeatureDm(Features featureDm) {
		this.featureDm = featureDm;
	}

	/**
	 * @return the featureValue
	 */
	public String getFeatureValue() {
		return featureValue;
	}

	/**
	 * @param featureValue the featureValue to set
	 */
	public void setFeatureValue(String featureValue) {
		this.featureValue = featureValue;
	}
	
	

	
	
	
	
	

}

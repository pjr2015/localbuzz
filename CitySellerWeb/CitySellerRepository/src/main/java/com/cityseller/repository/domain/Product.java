/**
 * 
 */
package com.cityseller.repository.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author jeetendra.patidar
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID", updatable = true, nullable = false, insertable = false)
	private long productId;
	
	
	@Column(name = "MODEL_ID", updatable = true, nullable = false, insertable = true)
	private String modelId;
	
	
	@Column(name = "NAME", updatable = true, nullable = false, insertable = true)
	private String productName;
	
	@Column(name = "DESCRIPTION", updatable = true, nullable = false, insertable = true)
	private String description;
	
	@OneToMany(mappedBy="productDm", cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.LAZY)
    private Set<ProductFeature> productFeatures;

	
	public Product() {
		// TODO Auto-generated constructor stub
		
		setProductFeatures(new HashSet<ProductFeature>());
	}
	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the modelId
	 */
	public String getModelId() {
		return modelId;
	}

	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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

	/**
	 * @return the productFeatures
	 */
	public Set<ProductFeature> getProductFeatures() {
		return productFeatures;
	}

	/**
	 * @param productFeatures the productFeatures to set
	 */
	public void setProductFeatures(Set<ProductFeature> productFeatures) {
		this.productFeatures = productFeatures;
	}
	
	

	
	
	
	
	

}

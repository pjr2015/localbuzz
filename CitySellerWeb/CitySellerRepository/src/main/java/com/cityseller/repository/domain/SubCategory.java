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
import javax.persistence.Table;

/**
 * @author jeetendra.patidar
 *
 */
@Entity
@Table(name = "SUB_CATEGORY")
public class SubCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_CATEGORY_ID", updatable = true, nullable = false, insertable = false)
	private long subCategoryId;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_CATEGORY_NAME", updatable = true, nullable = false, insertable = true)
	private String subCategoryName;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	private Category categoryDm;

	/**
	 * @return the subCategoryId
	 */
	public long getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId the subCategoryId to set
	 */
	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}

	/**
	 * @param subCategoryName the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	/**
	 * @return the categoryDm
	 */
	public Category getCategoryDm() {
		return categoryDm;
	}

	/**
	 * @param categoryDm the categoryDm to set
	 */
	public void setCategoryDm(Category categoryDm) {
		this.categoryDm = categoryDm;
	}


	
	
	
	

}

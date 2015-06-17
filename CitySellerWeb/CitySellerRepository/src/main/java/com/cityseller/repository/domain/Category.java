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
@Table(name = "CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID", updatable = true, nullable = false, insertable = false)
	private long categoryId;
	
	
	@Column(name = "CATEGORY_NAME", updatable = true, nullable = false, insertable = true)
	private String categoryName;

	
	@OneToMany(mappedBy="categoryDm", cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.LAZY)
    private Set<SubCategory> subCategories;

	public Category() {
		// TODO Auto-generated constructor stub
		setSubCategories(new HashSet<SubCategory>());
	}
	
	/**
	 * @return the categoryId
	 */
	public long getCategoryId() {
		return categoryId;
	}


	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}


	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	/**
	 * @return the subCategories
	 */
	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}


	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	
	
	

}

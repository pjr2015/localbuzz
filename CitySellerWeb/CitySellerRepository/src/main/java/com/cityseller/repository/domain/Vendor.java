/**
 * 
 */
package com.cityseller.repository.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author pavan.gupta
 *
 */
@Entity
@Table(name="vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "VENDOR_ID", updatable = true, nullable = false, insertable = false)
	private Long vendorId;
	
	@Column(name = "FIRST_NAME", updatable = true, insertable = true)
	private String firstName;
	
	@Column(name = "LAST_NAME", updatable = true, insertable = true)
	private String lastName;
	
	@Column(name = "SHOP_NAME", updatable = true, insertable = true)
	private String shopName;
	
	@Column(name = "REGISTRATION_DATE", updatable = true, insertable = true)
	private Date registrationDate;
	
	@Column(name = "REGISTRATION_NUMBER", updatable = true, insertable = true)
	private String registrationNumber;
	
	@Column(name = "MOBILE_NUMBER", updatable = true, insertable = true)
	private Integer mobileNumber;
	
	@Column(name = "LANDLINE_NUMBER", updatable = true, insertable = true)
	private Integer landlineNumber;
	
	@Column(name = "CONTACT_NUMBER", updatable = true, insertable = true)
	private Integer contactNumber;
	
	@Column(name = "EMAIL_ID", updatable = true, insertable = true)
	private String emailId;
	
	@Column(name = "CREATED_DATE", updatable = true, insertable = true)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", updatable = true, insertable = true)
	private String createdBy;
	
	@Column(name = "MODIFIED_DATE", updatable = true, insertable = true)
	private Date modifiedDate;
	
	@Column(name = "MODIFIED_BY", updatable = true, insertable = true)
	private String modifiedBy;
	
	@OneToOne(cascade=CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private UserDetails  userDetails;
	
	@ManyToMany(cascade = CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinTable(name="city_vendor_xref", joinColumns={@JoinColumn(name="VENDOR_ID")}, inverseJoinColumns={@JoinColumn(name="CITY_AREA_ID")})
	private List<CityArea> cityAreas;
	
	

	/**
	 * @return the cityAreas
	 */
	public List<CityArea> getCityAreas() {
		return cityAreas;
	}

	/**
	 * @param cityAreas the cityAreas to set
	 */
	public void setCityAreas(List<CityArea> cityAreas) {
		this.cityAreas = cityAreas;
	}

	/**
	 * @return the vendorId
	 */
	public Long getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the registrationDate
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the mobileNumber
	 */
	public Integer getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the landlineNumber
	 */
	public Integer getLandlineNumber() {
		return landlineNumber;
	}

	/**
	 * @param landlineNumber the landlineNumber to set
	 */
	public void setLandlineNumber(Integer landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	/**
	 * @return the contactNumber
	 */
	public Integer getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the userDetails
	 */
	public UserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", shopName=" + shopName
				+ ", registrationDate=" + registrationDate
				+ ", registrationNumber=" + registrationNumber
				+ ", mobileNumber=" + mobileNumber + ", landlineNumber="
				+ landlineNumber + ", contactNumber=" + contactNumber
				+ ", emailId=" + emailId + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", modifiedDate=" + modifiedDate
				+ ", modifiedBy=" + modifiedBy + ", userDetails=" + userDetails
				+ "]";
	}
}

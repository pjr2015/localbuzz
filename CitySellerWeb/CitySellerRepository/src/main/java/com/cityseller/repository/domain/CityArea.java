/**
 * 
 */
package com.cityseller.repository.domain;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author pavan.gupta
 *
 */
@Entity
@Table(name="city_area")
public class CityArea {

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityArea [cityAreaId=" + cityAreaId + ", areaName=" + areaName
				+ ", zipCode=" + zipCode  + "]";
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "CITY_AREA_ID", updatable = true, nullable = false, insertable = true)
	private Long cityAreaId;
	
	@Column(name = "AREA_NAME", updatable = true, insertable = true)
	private String areaName;
	
	@Column(name = "ZIPCODE", updatable = true, insertable = true)
	private Long zipCode;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinColumn(name="CITY_ID")
	private City city;
	
	@ManyToMany(mappedBy="cityAreas")
    private List<Vendor> vendors = new ArrayList<Vendor>();

	/**
	 * @return the vendors
	 */
	public List<Vendor> getVendors() {
		return vendors;
	}

	/**
	 * @param vendors the vendors to set
	 */
	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	/**
	 * @return the cityAreaId
	 */
	public Long getCityAreaId() {
		return cityAreaId;
	}

	/**
	 * @param cityAreaId the cityAreaId to set
	 */
	public void setCityAreaId(Long cityAreaId) {
		this.cityAreaId = cityAreaId;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the zipCode
	 */
	public Long getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
}

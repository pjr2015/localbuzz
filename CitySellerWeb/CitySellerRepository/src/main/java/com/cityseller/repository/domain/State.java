package com.cityseller.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {
	
	@Id
	@Column(name = "STATE_ID", updatable = true, nullable = false, insertable = true)
	private Long stateId;
	
	
	private Long countryId;
	
	private String stateName;

}

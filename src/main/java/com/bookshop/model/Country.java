package com.bookshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="countries")
public class Country implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="countryNo")
	private Integer countryNo;
	
	@Column(name="country")
	@NotEmpty(message="Country name is mandatory")
	private String country;

	public Integer getCountryNo() {
		return countryNo;
	}

	public void setCountryNo(Integer countryNo) {
		this.countryNo = countryNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String countryName) {
		this.country = countryName;
	}

/*	public String getCountryName() {
		return country;
	}

	public void setCountryName(String countryName) {
		this.country = countryName;
	}*/
	
	
}

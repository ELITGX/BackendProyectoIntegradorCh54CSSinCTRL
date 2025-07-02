package com.medicinasalternativasmx.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AddressDto {
	
    private Long id;

    
    private String city;

    
    private String state;

    
    private String postalCode;

    
    private String country;
    
    private long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public AddressDto(Long id, String city, String state, String postalCode, String country, long userId) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.userId = userId;
	}
    
    public AddressDto () {}
}

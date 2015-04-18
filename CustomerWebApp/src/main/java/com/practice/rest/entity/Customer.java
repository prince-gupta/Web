package com.practice.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.practice.rest.enums.CustomerStatus;


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	@Column
	@XmlElement
	private String firstName;
	@Column
	@XmlElement
	private String lastName;
	@Column
	@XmlElement
	private String street;
	@Column
	@XmlElement
	private String city;
	@Column
	@XmlElement
	private String state;
	@Column
	@XmlElement
	private String zip;
	@Column
	@XmlElement
	private String country;
	
	@Transient
	@XmlElement
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Transient
	public String getStatus(CustomerStatus status){
		return status.getDisplayValue();
	}
	public void setStatus(CustomerStatus statusCode){
		this.status = statusCode.getDisplayValue();
	}

}

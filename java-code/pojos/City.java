package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cities")
public class City {
	
	private Integer city_id;
	private String cityName;
	
	@JsonBackReference
	private List<Doctor> doctors=new ArrayList<>();
	
	public City() {
		System.out.println("City pojo created!!");
	}

	

	public City(String cityName) {
		super();
		this.cityName = cityName;
	}

	

	/*
	 * public City(Integer city_id, String cityName) { super(); this.city_id =
	 * city_id; this.cityName = cityName; }
	 */



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCity_id() {
		return city_id;
	}



	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}



	@Column(length = 30)
	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city",fetch = FetchType.EAGER)
	public List<Doctor> getDoctors() {
		return doctors;
	}



	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}



	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", cityName=" + cityName + "]";
	}



	
	
	

}

package com.app.dao;

import java.util.List;

import com.app.pojos.City;
import com.app.pojos.Specialization;

public interface ICityDao {
	public List<City> allCities();
	public City searchCity(String cityName);
	public List<Specialization> allSpecialization();
}

package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICityDao;
import com.app.pojos.City;
import com.app.pojos.Specialization;

@RestController
@RequestMapping("/patient")
@CrossOrigin(allowedHeaders = ("*"))
public class PatientController {
	
	public PatientController() {
		System.out.println("In patient Controller");
	}
	
	@Autowired
	private ICityDao daoCity;
	
	@GetMapping("/searchcity")
	public List<City> displayCities()
	{
		return daoCity.allCities();
	}
	
	@GetMapping("/searchspec")
	public List<Specialization> displaySpecialization()
	{
		return daoCity.allSpecialization();
	}
	

}

package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICityDao;
import com.app.dao.IDoctorDao;
import com.app.pojos.City;
import com.app.pojos.Doctor;
import com.app.pojos.QualificationType;
import com.app.pojos.Specialization;
import com.app.pojos.User;


@RestController
@RequestMapping("/doctor")
@CrossOrigin(allowedHeaders = "*")
public class DoctorController {

	@Autowired
	private IDoctorDao daoDoctor;

	private ICityDao daoCity;

	public DoctorController() {
		System.out.println("in DoctorController");
	}

//	City cities=(City) daoCity.allCities();	
	/*
	 * @GetMapping("/{city_id}") public List<Doctor> displayDoctors(@PathVariable
	 * int city_id) { List<Doctor> l = daoDoctor.listDoctors(city_id);
	 * 
	 * List<Doctor> lr = new ArrayList<>(); for (Doctor doctor : l) { Doctor d = new
	 * Doctor(doctor.getFirstName()); lr.add(d); }
	 * 
	 * return lr; }
	 */
	
	/*
	 * @GetMapping("/{city_id}") public List<Doctor> displayDoctors(@PathVariable
	 * int city_id) { List<Doctor> l = daoDoctor.listDoctors(city_id);
	 * 
	 * List<Doctor> lr = new ArrayList<>(); for (Doctor doctor : l) { Doctor d = new
	 * Doctor(doctor.getFirstName()); lr.add(d); }
	 * 
	 * return lr; }
	 */
	@PostMapping("/login")
	public Doctor login(@RequestBody Doctor doctor) {
		System.out.println(doctor);
		return daoDoctor.login(doctor);
	}
	
	@PostMapping("/searchdoct")
	public List<Doctor> searchDoct(@RequestBody City city)
	{
		
		System.out.println(city);
		
		return daoDoctor.listDoctors(city.getCityName());	}
	
	@PostMapping("/searchdoctByspec")
	public List<Doctor> searchDoctByspec(@RequestBody Specialization spec)
	{
		
		System.out.println(spec);
		
		return daoDoctor.listBySpecs(spec.getSpecialization());	
	}
	
	@GetMapping("/doctorprofile")
	public Doctor displayProfile(@RequestParam int doctorId)
	{
		System.out.println("display doct profile controller!!!");
		return daoDoctor.doctorProfile(doctorId) ;
	}
	
	@GetMapping("/qualifications")
	public List<QualificationType> displayQualifications(){
		return daoDoctor.listQualifications();
	}
}

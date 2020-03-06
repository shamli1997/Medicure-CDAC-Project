package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IDoctorDao;
import com.app.pojos.City;
import com.app.pojos.Doctor;
import com.app.pojos.Specialization;
import com.app.service.Idoctservice;

@RestController
@RequestMapping("/admin")
@CrossOrigin(allowedHeaders = "*")
public class AdminController {

	@Autowired
	IDoctorDao daoDoc;

	@Autowired
	Idoctservice service;

	@PostMapping("/deletedoctor")
	public List<Doctor> processDeleteDoctors(@RequestBody Doctor doc) {

		Doctor d = daoDoc.doctorProfile(doc.getDoctorId());
		System.out.println("inside delete doctor controller method " + d);
		 daoDoc.deleteDoctorDetails(d);
		 return daoDoc.displayDoctorAfterDeletion();
	}

	@PostMapping("/register")
	public boolean processRegisterDoctor(@RequestBody Doctor doc) {

		//Integer cityid = doc.getCity().getCity_id();

		/*
		 * City c = ; doc.setCity(c);
		 * 
		 * Specialization spec = doc.getSpecs();
		 */

		//System.out.println(c + " " + spec + "" + doc.getFirstName());

		System.out.println("inside process register doctor method of controller--->"+doc);
		daoDoc.registerDoctor(doc);
		return true;

	}
	
	@GetMapping("/listdoctors")
	public List<Doctor> displayAllDoctors(){
		return daoDoc.listAllDoctors();
	}

	/*
	 * @GetMapping("/{doctorId}") public ResponseEntity<String>
	 * updateDoctorDetails(@RequestBody Doctor user, @PathVariable int doctorId) {
	 * System.out.println("Inside updateDoctorDetails" + user);
	 * System.out.println(doctorId); System.out.println("Admin controller--->" +
	 * user);
	 * 
	 * try { service.updateDetails(doctorId, user); return new
	 * ResponseEntity<String>("Update Successful", HttpStatus.OK); } catch
	 * (RuntimeException e) { e.printStackTrace(); return new
	 * ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	
	/*
	 * @DeleteMapping("/{doctorId}") public ResponseEntity<String>
	 * delEmpDetails(@PathVariable int doctorId) {
	 * System.out.println("in del doctor "+doctorId); try { return new
	 * ResponseEntity<String>(service.deletedoctInfo(doctorId),HttpStatus.OK);
	 * }catch (RuntimeException e1) { e1.printStackTrace(); return new
	 * ResponseEntity<String>(e1.getMessage(), HttpStatus.NOT_FOUND); } }
	 */
	
	@PutMapping("/update/{doctorId}")
	public ResponseEntity<String> updateEmpDetails(@PathVariable int doctorId, @RequestBody Doctor e) {
		System.out.println("in update " + doctorId + " " + e);
		// invoke service's method
		try {
			return new ResponseEntity<String>(service.updateDetails(doctorId, e), HttpStatus.OK);
		} catch (RuntimeException e1) {
			e1.printStackTrace();
			return new ResponseEntity<String>(e1.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/list/{doctorId}")
	public ResponseEntity<?> getEmpDtls(@PathVariable int doctorId) {
		System.out.println("in get doctor dtls " + doctorId);
		Doctor doctor = service.getDoctDetails(doctorId);
		if (doctor == null)
			return new ResponseEntity<String>("Emp not found...", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);

	}

}

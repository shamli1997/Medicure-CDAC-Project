package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDoctorDao;
import com.app.dao.IUserDao;
import com.app.pojos.Doctor;

@Service
@Transactional
public class doctorService implements Idoctservice {

	@Autowired
	private IDoctorDao dao;
	
	/*
	 * @Override public void updateDetails(int doctorId, Doctor u) {
	 * System.out.println(doctorId);
	 * System.out.println("service updateDetails---->"+u); Doctor
	 * u1=dao.getUserDetails(doctorId); System.out.println(u1);
	 * u1.setFirstName(u.getFirstName()); u1.setLastName(u.getLastName());
	 * u1.setEmail(u.getEmail()); u1.setPassword(u.getPassword());
	 * u1.setPhone(u.getPhone());
	 * 
	 * //u.setUserId(userId); dao.updateDoctorDetails(u1);
	 * 
	 * }
	 */
	
	@Override
	public String updateDetails(int doctorId, Doctor e) {
		// confirm if emp exists
		Doctor e1 = dao.getUserDetails(doctorId);
		if (e1 == null)
			throw new RuntimeException("doctor ID invalid");
		// update

		return dao.updateDoctDetails(e);
	}

	
	
	
	@Override
	public String deletedoctInfo(int doctorId) {
		// confirm if emp exists
		Doctor e1 = dao.getUserDetails(doctorId);
		if (e1 == null)
			throw new RuntimeException("Doctor ID invalid");

		return dao.deletedoctorInfo(e1);
	}




	@Override
	public Doctor getDoctDetails(int doctorId) {
		
		return dao.getUserDetails(doctorId);
	}

}

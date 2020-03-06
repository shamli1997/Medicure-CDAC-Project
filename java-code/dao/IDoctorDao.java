package com.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.app.pojos.City;
import com.app.pojos.Doctor;
import com.app.pojos.QualificationType;

public interface IDoctorDao {
	public List<Doctor> listDoctors(String cityName);
	public List<Doctor> listBySpecs(String spec);
	public Doctor doctorProfile(int doctorId);
	public Doctor login(Doctor doctor);
	public String registerDoctor(Doctor doc);
	public String deleteDoctorDetails(Doctor doc);
	public Doctor getUserDetails(int doctorId);
	public List<QualificationType> listQualifications();
	public void updateDoctorDetails(Doctor doc);
	public List<Doctor> listAllDoctors();
	public List<Doctor> displayDoctorAfterDeletion();
	public String deletedoctorInfo(Doctor d);
	
	public String updateDoctDetails(Doctor e);
	
	//public HashMap<String, String> listDoctors(String cityName);


	

}

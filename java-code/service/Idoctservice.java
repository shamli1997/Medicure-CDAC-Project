package com.app.service;

import com.app.pojos.Doctor;

public interface Idoctservice {
	//public void updateDetails(int doctorId,Doctor d);
	public String deletedoctInfo(int doctorId);
	public String updateDetails(int doctorId, Doctor e);
	public Doctor getDoctDetails(int doctorId);
	

}

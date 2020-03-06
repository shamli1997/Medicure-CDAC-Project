package com.app.dao;

import java.util.List;

import com.app.pojos.Appointment;
//import com.app.pojos.AppointmentSlot;
import com.app.pojos.Doctor;
//import com.app.pojos.Slot;
import com.app.pojos.Slots;
import com.app.pojos.User;

public interface IAppointmentDao {
	//public void createAppointment( User patient,Doctor doctor,AppointmentSlot appointmentSlot);

	public Integer createAppointment(Appointment ap);
	public List<Slots> showSlotlist();
	public List<Appointment> patientAppointmentList(int userId);
	public List<Appointment> doctorAppointmentList(int doctorId);
	public List<Appointment> doctorAppointmentList1(int doctorId);

}

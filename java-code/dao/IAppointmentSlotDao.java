package com.app.dao;

import java.util.List;

import com.app.pojos.Appointment;
import com.app.pojos.City;
import com.app.pojos.Slots;

//import com.app.pojos.AppointmentSlot;

public interface IAppointmentSlotDao {
	public Slots getById(int id);

	public List<Slots> getapslotlist(Integer doctorId);
	public List<Slots> allSlots();
	public boolean validateSlot(Appointment ap);

}

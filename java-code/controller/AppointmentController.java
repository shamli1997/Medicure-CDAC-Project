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

import com.app.dao.ApppointmentDaoImpl;
import com.app.dao.IAppointmentDao;
import com.app.dao.IAppointmentSlotDao;
import com.app.pojos.Appointment;
//import com.app.pojos.AppointmentSlot;
import com.app.pojos.Doctor;
//import com.app.pojos.Slot;
import com.app.pojos.Slots;
import com.app.pojos.Specialization;
import com.app.pojos.User;

@RestController
@RequestMapping("/apcnt")
@CrossOrigin(allowedHeaders = "*")
public class AppointmentController {
	
	@Autowired
	private IAppointmentDao apptdao;
	
	@Autowired
	private IAppointmentSlotDao slotdao;
	
	public AppointmentController() {
		System.out.println("In appointment controller!!");
	}
	
	@PostMapping("/bookappointment")
	public boolean createAppointments(@RequestBody Appointment ap)
	//public void createAppointments(@RequestParam int doctorId)
	{
		//System.out.println(ap.getStartTime());
		boolean isbooked=slotdao.validateSlot(ap);
		System.out.println(ap.getApptDate());
		System.out.println("user in bookappointment:"+ap);
		if(isbooked)
		{
		apptdao.createAppointment(ap);
		return true;
		}
		else
			return false;
	}
	
	/*
	 * @GtMapping("/slots") public List<Slots> displaySlots() { List<Slots>
	 * slots=slotdao.allSlots(); List<Slots> list = new ArrayList<>();
	 * System.out.println(slots); for(Slots s : slots) { Slots sl = new
	 * Slots(s.getSlot_id(),s.getSlots()); //sl.setSlots(s.getSlots());
	 * System.out.println(sl); list.add(sl); } return list; }
	 */
	
	
	@GetMapping("/slots")
	public List<Slots> displayAllSlots()
	{
		return slotdao.allSlots();
	}
	
	@GetMapping("/viewAppointments/{userId}")
	public List<Appointment> displayAppoinmentSchedule(@PathVariable int userId)
	{
		
		return apptdao.patientAppointmentList(userId);
	}
	
	@GetMapping("/viewdoctSchedule/{doctorId}")
	public List<Appointment> displayDoctorAppoinmentSchedule(@PathVariable int doctorId)
	{
		
		return apptdao.doctorAppointmentList(doctorId);
	}

}

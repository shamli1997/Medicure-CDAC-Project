package com.app.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointment;
//import com.app.pojos.AppointmentSlot;
import com.app.pojos.City;
//import com.app.pojos.Slot;
import com.app.pojos.Slots;

@Repository
@Transactional
public class ApppointmentDaoImpl implements IAppointmentDao {
	
	@Autowired
	private IAppointmentSlotDao slotdao;
	
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer createAppointment(Appointment ap) {
		
		
		/*
		 * Slots slot=slotdao.getById(ap.getSlot_id()); slot.setBooked(true);
		 * Appointment appointment=new Appointment(doctor, patient,
		 * slot.getStartTime(),slot.getEndTime());
		 * sf.getCurrentSession().persist(appointment);
		 * sf.getCurrentSession().persist(slot);
		 */
		  
		 
		/*
		 * List<Slots> apslotlist = slotdao.getapslotlist(ap.getDoctor().getDoctorId());
		 * sf.getCurrentSession().save(ap);
		 */
		
		return  (Integer) sf.getCurrentSession().save(ap);
		
		
	}

	@Override
	public List<Slots> showSlotlist() {
		System.out.println("slot dao");
		String jpql = "select s.slots from Slots s";
		return sf.getCurrentSession().createQuery(jpql,Slots.class).getResultList();
	}

	@Override
	public List<Appointment> patientAppointmentList(int userId) {
		System.out.println("patientAppointment dao");
		String jpql="select a from Appointment a where a.patient.userId=:p_id";
		
		List<Appointment>apps=  sf.getCurrentSession().createQuery(jpql,Appointment.class).
				setParameter("p_id", userId).getResultList();
		
 Date currentDate = new Date();
		 
		 List<Appointment>filterappt=new ArrayList<Appointment>();
	        
		for(Appointment a:apps) {
			Date date1 =a.getApptDate();
			if(date1.compareTo(currentDate)>=0) {
				Appointment app1=new Appointment(a.getDoctor(), a.getPatient(),a.getApptDate(),a.getSlots(),a.getBooked());
				filterappt.add(app1);
				System.out.println(app1);
			}
		}
		
		return filterappt;
	}

	@Override
	public List<Appointment> doctorAppointmentList1(int doctorId) {
		System.out.println("doctorAppointment dao");
		String jpql="select a from Appointment a where a.doctor.doctorId=:d_id";
		
		return sf.getCurrentSession().createQuery(jpql,Appointment.class).
				setParameter("d_id", doctorId).getResultList();
	}
	
	@Override
	public List<Appointment> doctorAppointmentList(int doctorId) {
		System.out.println("doctorAppointment dao");
		String jpql="select a from Appointment a where a.doctor.doctorId=:d_id";
		
		List<Appointment>apps= sf.getCurrentSession().createQuery(jpql,Appointment.class).
				setParameter("d_id", doctorId).getResultList();
		
		
		 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     // LocalDateTime ldt=  LocalDateTime.now();
	//	todayDate = dateFormatter.parse(dateFormatter.format(new Date() ));
		 Date currentDate = new Date();
		 
		 List<Appointment>filterappt=new ArrayList<Appointment>();
	        
		for(Appointment a:apps) {
			Date date1 =a.getApptDate();
			if(date1.compareTo(currentDate)>=0) {
				Appointment app1=new Appointment(a.getDoctor(), a.getPatient(),a.getApptDate(),a.getSlots(),a.getBooked());
				filterappt.add(app1);
				System.out.println(app1);
			}
		}
		
		return filterappt;
	}

}
